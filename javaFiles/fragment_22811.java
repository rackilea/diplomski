package com.ggl.stock.picker.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.SwingUtilities;

import com.ggl.stock.picker.model.Company;
import com.ggl.stock.picker.model.StockDay;
import com.ggl.stock.picker.model.StockHistory;
import com.ggl.stock.picker.model.StockPickerModel;
import com.ggl.stock.picker.view.StockPickerFrame;

public class HistoricalDataRunnable implements Runnable {

    private static final String URLString = 
                  "http://www.google.com/finance/historical?output=csv&q=";

    private Company company;

    private StockPickerFrame frame;

    private StockPickerModel model;

    public HistoricalDataRunnable(StockPickerFrame frame,
            StockPickerModel model, Company company) {
        this.frame = frame;
        this.model = model;
        this.company = company;
    }

    @Override
    public void run() {
        InputStream is = null;
        BufferedReader br = null;

        try {
            String symbol = company.getStockSymbol();

            URL url = new URL(URLString + symbol);
            URLConnection hc = url.openConnection();
            hc.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; "
                    + "Intel Mac OS X 10.4; en-US; rv:1.9.2.2) "
                    + "Gecko/20100316 Firefox/3.6.2");
            is = hc.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            processCSVFile(br);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            String message = e.getMessage();
            message = "<html>" + message;
            setMessageLabel(message);
        } catch (IOException e) {
            String message = e.getMessage();
            message = "<html>" + message;
            setMessageLabel(message);
        } finally {
            closeReaders(is, br);
        }
    }

    private void processCSVFile(BufferedReader br) throws IOException {
        String line = "";
        int count = 0;
        StockHistory history = new StockHistory(company);
        while ((line = br.readLine()) != null) {
            if (count > 0) {
                StockDay stockDay = createStockDay(line);
                if (stockDay != null) {
                    history.addStockDay(stockDay);
                }
            }
            count++;
        }
        if (history.calculateNumbers()) {
            model.addStockHistory(history);
            addStockHistory();
            setMessageLabel(" ");
        } else {
            String message = "<html>There is no data for "
                    + company.getCompanyName();
            setMessageLabel(message);
        }
    }

    private StockDay createStockDay(String line) {
        String[] parts = line.split(",");
        if (parts[1].equals("-"))
            return null;

        double open = Double.valueOf(parts[1]);
        double high = Double.valueOf(parts[2]);
        double low = Double.valueOf(parts[3]);
        double close = Double.valueOf(parts[4]);
        long volume = Long.valueOf(parts[5]);
        return new StockDay(parts[0], open, high, low, close, volume);
    }

    private void addStockHistory() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.addStockHistory();
            }
        });
    }

    private void setMessageLabel(final String text) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setMessageLabel(text);
                ;
            }
        });
    }

    private void closeReaders(InputStream is, BufferedReader br) {
        try {
            if (br != null)
                br.close();
            if (is != null)
                is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}