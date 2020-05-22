package com.js.extract;

import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.htmlparser.beans.StringBean;
import org.htmlparser.util.ParserException;

public class Extraction_GUI extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    protected JButton start;
    protected JButton sendInfo;
    protected JTextArea infoArea;
    protected static JTextArea log;
    protected JScrollPane sp;
    protected JScrollPane sp2;
    protected JSplitPane pane;
    protected JPanel mainPanel;
    protected JPanel aPanel;
    protected JPanel lPanel;
    protected int areaStatus = 0;
    static protected Calendar cal = Calendar.getInstance();
    protected static ArrayList<String> urls = new ArrayList<String>();

    public Extraction_GUI() {
        super("Extraction by Jeel Shah");
        setSize(660, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());

        aPanel = new JPanel();
        aPanel.setLayout(new FlowLayout());

        lPanel = new JPanel();
        lPanel.setLayout(new FlowLayout());

        start = new JButton("start");
        sendInfo = new JButton("send info");
        infoArea = new JTextArea("http://www.freddiemac.com/debt/data/cgi-bin/cusipdetail.cgi?cusip=3133F0GM5", 13, 55);

        log = new JTextArea(10, 55);
        log.setEditable(false);

        sp = new JScrollPane(infoArea);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        sp2 = new JScrollPane(log);
        sp2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        aPanel.add(sp);
        lPanel.add(sp2);

        pane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, aPanel, lPanel);

        mainPanel.add(pane);
        mainPanel.add(start);
        mainPanel.add(sendInfo);

        add(mainPanel);

        setVisible(true);
        final String toSave = JOptionPane.showInputDialog(null, "Please enter where you would like to save your files: ");
        log.append("Data will be saved to: " + toSave + "\n");

        sendInfo.addActionListener(new infoListener());
        start.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    start(toSave);
                } catch (ParserException e1) {
                    e1.printStackTrace();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

// start
    public static void start(String file) throws ParserException, IOException {

        for (int i = 0; i < urls.size(); i++) {
            // First mistake was in the following line.
            BufferedWriter writer = new BufferedWriter(new FileWriter(file + "/CUSIP" + i + ".csv"));
            StringBean sb = new StringBean();
            sb.setLinks(false);
            sb.setReplaceNonBreakingSpaces(true);

            sb.setCollapse(true);
            sb.setURL(urls.get(i));
            String toReduce = sb.getStrings();

            System.out.println("toReduce = \n" + toReduce);

            StringBuffer buffer = new StringBuffer(toReduce);

        if (toReduce.contains("*CUSIP Detail information will be available when this issue settles.")) {
            log.append("CUSIP Detail not available.For " + urls.get(i) + "\n");
        } else {
            buffer.delete(0, toReduce.indexOf("Cusip/ISIN")-1);
            // The following line removes info about Underwriters from parsing. So, I commented it.
            //buffer.delete(buffer.indexOf("Underwriters:"), buffer.length());

            String[] data = new String[14];

            data[0] = buffer.substring(0, buffer.indexOf("Instrument Type:"));
            data[1] = buffer.substring(buffer.indexOf("Instrument Type:"), buffer.indexOf("Call Type:"));
            data[2] = buffer.substring(buffer.indexOf("Call Type:"), buffer.indexOf("Issue Date:"));
            data[3] = buffer.substring(buffer.indexOf("Issue Date:"), buffer.indexOf("Issue Price:"));
            data[4] = buffer.substring(buffer.indexOf("Issue Price:"), buffer.indexOf("Amount Issued:"));
            data[5] = buffer.substring(buffer.indexOf("Amount Issued:"), buffer.indexOf("Lockout Period:"));
            data[6] = buffer.substring(buffer.indexOf("Lockout Period:"), buffer.indexOf("Currency"));
            data[7] = buffer.substring(buffer.indexOf("Currency"), buffer.indexOf("Denomination:"));
            data[8] = buffer.substring(buffer.indexOf("Denomination:"), buffer.indexOf("First Payment"));
            data[9] = buffer.substring(buffer.indexOf("First Payment"), buffer.indexOf("Maturity Date"));
            data[10] = buffer.substring(buffer.indexOf("Maturity Date"), buffer.indexOf("Original Coupon:"));
            data[11] = buffer.substring(buffer.indexOf("Original Coupon:"), buffer.indexOf("Current Coupon:"));
            // Some changes are made in that line:
            data[12] = buffer.substring(buffer.indexOf("Current Coupon:"), buffer.indexOf("Underwriters:"));
            // This line is added.
            data[13] = buffer.substring(buffer.indexOf("Underwriters:"), buffer.length());

            for (String s : data) {
                writer.write(s);
                writer.write(",");
                writer.newLine();
            }
        }
            writer.flush();
            writer.close();
            log.append("Harvested: " + urls.get(i) + " successfully" + " \n");

        }
        log.append("Completed at: " + cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND) + "\n");
    }

    class infoListener implements ActionListener {

        public void actionPerformed(ActionEvent arg0) {
            String url = infoArea.getText();

            StringTokenizer st = new StringTokenizer(url, ",");

            while (st.hasMoreTokens()) {
                urls.add(st.nextToken());
            }
            log.append("Data Recieved at: " + cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND) + "\n");
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                new Extraction_GUI();
            }
        });
    }
}