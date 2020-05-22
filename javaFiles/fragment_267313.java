package org.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

public class GUIroughdraft {

private JFrame frmBgszStockSimulator;
/**
 * @wbp.nonvisual location=53,14
 */
//private final JLabel lblBgszStockSimulator = DefaultComponentFactory.getInstance().createTitle("BGSZ Stock Simulator");
private  JTextField searchBar;
private JTable table;
private  JTextField displayBox;
private  JButton searchButton;

/**
 * Launch the application. Testing Comment
 */
public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            GUIroughdraft window = new GUIroughdraft();
            try {
                window = new GUIroughdraft();
                window.frmBgszStockSimulator.setVisible(true);


            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    });
}

/**
 * Create the application.
 */
public GUIroughdraft() {
    try {
        initialize();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}

/**
 * Initialize the contents of the frame.
 * @throws IOException 
 */
private void initialize() throws IOException 
{
    frmBgszStockSimulator = new JFrame();
    frmBgszStockSimulator.getContentPane().setBackground(Color.WHITE);
    frmBgszStockSimulator.setTitle("BGSZ Stock Simulator");
    frmBgszStockSimulator.setBounds(100, 100, 802, 510);
    frmBgszStockSimulator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JMenuBar menuBar = new JMenuBar();
    frmBgszStockSimulator.setJMenuBar(menuBar);

    JMenu mnFile = new JMenu("File");
    menuBar.add(mnFile);

    JMenuItem mntmSave = new JMenuItem("Save");
    mnFile.add(mntmSave);
    mntmSave.addActionListener(new ActionListener() 
    {

        @Override
        public void actionPerformed(ActionEvent arg0) 
        {
            JFileChooser saveFile = new JFileChooser();
            saveFile.setSelectedFile(new File(".csv"));
            saveFile.showSaveDialog(null);
        }
    });

    JMenuItem mntmLoad = new JMenuItem("Load");
    mnFile.add(mntmLoad);
    mntmLoad.addActionListener(new ActionListener() 
    {

            @Override
            public void actionPerformed(ActionEvent arg0) 
            {
                JFileChooser openFile = new JFileChooser();
                openFile.showOpenDialog(null);
            }
        });

    JMenuItem mntmOptions = new JMenuItem("Options");
    mnFile.add(mntmOptions);

    JMenu mnActions = new JMenu("Actions");
    menuBar.add(mnActions);

    JMenuItem mntmBuy = new JMenuItem("Buy");
    mnActions.add(mntmBuy);
    mntmBuy.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                JFrame frmBgszStockSimulatorBuy = new JFrame();
                frmBgszStockSimulatorBuy.getContentPane().setBackground(Color.RED);
                frmBgszStockSimulatorBuy.setTitle("Buy Stocks");
                frmBgszStockSimulatorBuy.setVisible(true);
                frmBgszStockSimulatorBuy.setBounds(100, 100, 500, 500);
//                JPanel p = new JPanel(); 
//                frmBgszStockSimulatorBuy.getContentPane().add(p);
//                p.setBackground(Color.gray);//To set panel background instead of frames background
//                frmBgszStockSimulatorBuy.add(p);
//
//                searchBar = new JTextField();
//                searchBar.setText("Enter your text here");
//                searchBar.setBounds(12, 300, 300, 22);
//                frmBgszStockSimulatorBuy.getContentPane().add(searchBar);
//                searchBar.setColumns(10);
//
                JTextArea displayBox = new JTextArea();
                displayBox.setEditable(false);
                displayBox.setLineWrap(true);
                displayBox.setWrapStyleWord(true);
                displayBox.setText("This will be a text field that displays all your actions and information about stocks, purchases, sales, errors, etc.");
//
                displayBox.setBounds(12, 47, 312, 317);

                frmBgszStockSimulatorBuy.getContentPane().add(displayBox, BorderLayout.PAGE_START);   //This is where BorderLayout.PAGE_START is added.       

            }


        });

    JMenuItem mntmSell = new JMenuItem("Sell");
    mnActions.add(mntmSell);

    JMenu mnHelp = new JMenu("Help");
    menuBar.add(mnHelp);

    JMenuItem mntmInfo = new JMenuItem("Info");
    mnHelp.add(mntmInfo);

    JMenuItem mntmAbout = new JMenuItem("How to Use");
    mnHelp.add(mntmAbout);
    frmBgszStockSimulator.getContentPane().setLayout(null);

    JScrollBar scrollBar = new JScrollBar();
    scrollBar.setBackground(Color.LIGHT_GRAY);
    scrollBar.setBounds(323, 47, 21, 317);
    frmBgszStockSimulator.getContentPane().add(scrollBar);

    JTextArea displayBox = new JTextArea();
    displayBox.setEditable(false);
    displayBox.setLineWrap(true);
    displayBox.setWrapStyleWord(true);
    displayBox.setText("This will be a text field that displays all your actions and information about stocks, purchases, sales, errors, etc.");

    displayBox.setBounds(12, 47, 312, 317);
    frmBgszStockSimulator.getContentPane().add(displayBox);

    searchBar = new JTextField();
    searchBar.setText("Enter your text here");
    searchBar.setBounds(12, 377, 637, 22);
    frmBgszStockSimulator.getContentPane().add(searchBar);
    searchBar.setColumns(10);

    JButton searchButton = new JButton();
    searchButton.setText("Search");
    searchButton.setBounds(654, 377, 93, 22);
    frmBgszStockSimulator.getContentPane().add(searchButton);
    searchButton.addActionListener(new ActionListener() 
    {
         public void actionPerformed(ActionEvent e) 
         {

             String userInput = searchBar.getText();

//                    GetStockData gd = new GetStockData();
//                    try 
//                    {
//                        gd.pullPriceData(userInput);
//
//                    } 
//                    catch (IOException er) 
//                    {
//                        er.printStackTrace();
//
//                    }
//
//                    String output = Double.toString(gd.getPrice());;
//                    if(output == "0")
//                    {
//                        displayBox.setText("NO STOCK FOUND");
//                    }
//                    displayBox.setText("The Price for " + userInput + ": $" + output);
                    //get to print in the table.
                    //userInput = stock ticker 
                    //ouput = price
            }
      });

    JProgressBar progressBar = new JProgressBar();
    progressBar.setStringPainted(true);
    progressBar.setValue(75);
    progressBar.setBounds(50, 412, 586, 14);
    frmBgszStockSimulator.getContentPane().add(progressBar);

    table = new JTable();
    table.setModel(new DefaultTableModel(
            new Object[][] {
                {"Stock Name", "Stock Value", "Amount Owned", "Total Value"},
                {" BAC", "$13.48", "4", "$53.92"},
                {" RIG", "$8.89", "0", "$0.00"},
                {" SUNE", "$0.59", "12", "$7.08"},
                {" FCX", "$10.29", "2", "$20.58"},
                {" PBR", "$5.86", "0", "$0.00"},
                {" GE", "$31.83", "0", "$0.00"},
                {" VALE", "$4.24", "24", "$101.76"},
                {" VRX", "$27.07", "0", "$0.00"},
                {" PFE", "$30.07", "0", "$0.00"},
                {" CRC", "$1.05", "8", "$8.40"},
                {" GGB", "$1.82", "0", "$0.00"},
                {" CHK", "$4.01", "6", "$24.06"},
                {" T", "$39.37", "0", "$0.00"},
                {" F", "$13.35", "5", "$66.75"},
                {" WLL", "$7.66", "0", "$0.00"},
            },
            new String[] {
                "New column", "New column", "New column", "New column"
            }
        ));
    table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
    table.setBounds(350, 51, 395, 313);
    frmBgszStockSimulator.getContentPane().add(table);

    JTextArea txtrValue = new JTextArea();
    txtrValue.setText("Displays Cash Value");
    txtrValue.setLineWrap(true);
    txtrValue.setEditable(false);
    txtrValue.setBounds(99, 12, 172, 22);
    frmBgszStockSimulator.getContentPane().add(txtrValue);

    JTextArea txtrCurrentPortfolioValue = new JTextArea();
    txtrCurrentPortfolioValue.setText("Display Portfolio Value");
    txtrCurrentPortfolioValue.setLineWrap(true);
    txtrCurrentPortfolioValue.setEditable(false);
    txtrCurrentPortfolioValue.setBounds(376, 12, 206, 22);
    frmBgszStockSimulator.getContentPane().add(txtrCurrentPortfolioValue);

    JLabel lblCashValue = new JLabel("Cash Value:");
    lblCashValue.setBounds(24, 15, 111, 16);
    frmBgszStockSimulator.getContentPane().add(lblCashValue);

    JLabel lblPortfolioValue = new JLabel("Portfolio Value:");
    lblPortfolioValue.setBounds(283, 15, 123, 16);
    frmBgszStockSimulator.getContentPane().add(lblPortfolioValue);
}
}

/*  private class customListener implements ActionListener {
    private GUIroughdraft window;

    public customListener(GUIroughdraft window) {
        this.window = window;
    }

    public void actionPerformed(ActionEvent e) {
     String userInput = window.searchBar.getText();
            GetStockData gd = new GetStockData();
            try {
                gd.pullPriceData(userInput);
            } catch (IOException er) {
                er.printStackTrace();
            }
            String output = Double.toString(gd.getPrice());
            window.displayBox.setText("The Price for " + userInput + ":" + output);
    }
}*/