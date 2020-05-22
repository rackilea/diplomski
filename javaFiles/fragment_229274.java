package stockdata;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import stockdata.StockData;

public class PurchaseItem extends JFrame implements ActionListener {
    // StockData ss = new StockData();
    JComboBox<String> box = new JComboBox<>(StockData.getStock().values().stream().map(StockData.Item::getName).toArray(String[]::new));
    JComboBox b = new JComboBox();

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub

    }
}