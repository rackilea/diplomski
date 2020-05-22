import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MyClass extends JFrame {
    private final JTextField item1;
    private final JTextField item2;
    private final JTextField item3;
    private final JTextField item4;
    private final JTextField item5;
    JLabel label1 = new JLabel("Enter number of items in this order:");
    JLabel label2 = new JLabel("Enter CD ID for Item #1:");
    JLabel label3 = new JLabel("Enter quantity for Item #1:");
    JLabel label4 = new JLabel("Item #1 info:");
    JLabel label5 = new JLabel("Order subtotal for 0 item(s):");
    private final JButton button1 = new JButton("Process Item #1");
    private final JButton button2 = new JButton("Confirm Item #1");
    private final JButton button3 = new JButton("View Order");
    private final JButton button4 = new JButton("Finish Order");
    private final JButton button5 = new JButton("New Order");
    private final JButton button6 = new JButton("Exit");
    private Scanner x;
    private final int exitFlag = 0;
    public String[] idArray = new String[10];
    public String[] recordArray = new String[10];
    public String[] priceArray = new String[10];
    public int myNum = 1;
    private final JPanel jp;

    public void openFile() {
        try {
            x = new Scanner(new File("inventory.txt"));
            x.useDelimiter(",|" + System.getProperty("line.separator"));
        } catch (Exception e) {
            System.out.println("Could not find file");
        }
    }

    public void readFile() {
        int i = 0;
        while (x.hasNext()) {
            idArray[i] = x.next();
            recordArray[i] = x.next();
            priceArray[i] = x.next();
            i++;
        }
    }

    public int itemNum(int num) {
        return num + 1;
    }

    public MyClass() {
        super("Matt's World of Music");

        jp = new JPanel();
        jp.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        c.anchor = GridBagConstraints.BASELINE_TRAILING;

        // Box vertBox = Box.createVerticalBox();
        // Box vertBox2 = Box.createVerticalBox();
        // Box itemBox2 = Box.createHorizontalBox();

        item1 = new JTextField(40);
        item2 = new JTextField(40);
        item3 = new JTextField(40);
        item4 = new JTextField(40);
        item5 = new JTextField(40);

        c.gridx = 0;
        c.gridy = 0;
        jp.add(label1, c);

        c.gridy++;
        jp.add(label2, c);

        c.gridy++;
        jp.add(label3, c);

        c.gridy++;
        jp.add(label4, c);

        c.gridy++;
        jp.add(label5, c);

        c.gridx = 1;
        c.gridy = 0;
        jp.add(item1, c);

        c.gridy++;
        jp.add(item2, c);

        c.gridy++;
        jp.add(item3, c);

        c.gridy++;
        jp.add(item4, c);

        c.gridy++;
        jp.add(item5, c);

        JPanel btnPan = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnPan.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        btnPan.add(button1);
        btnPan.add(button2);
        btnPan.add(button3);
        btnPan.add(button4);
        btnPan.add(button5);
        btnPan.add(button6);

        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy++;
        jp.add(btnPan, c);
        add(jp);

        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);
        item4.setEditable(false);
        item5.setEditable(false);

        // Process Item
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyClass obj = new MyClass();

                button1.setEnabled(false);
                button2.setEnabled(true);
                item1.setEditable(false);

                obj.openFile();
                obj.readFile();

                // start loop
                for (int i = 0; i < idArray.length; i++) {
                    if (item2.getText().equals(obj.idArray[i]) == true) {
                        // set item4 text field to price id and other details
                        item4.setText(obj.idArray[i] + " " + obj.recordArray[i] + " $"
                                + obj.priceArray[i].replaceAll("\\s", ""));
                    }
                }
            }
        });
        // Confirm Item
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (myNum == Integer.parseInt(item1.getText())) {
                    JOptionPane.showMessageDialog(null, "Item #" + (myNum) + " accepted");
                    button2.setEnabled(false);
                    button1.setText("Process Item");
                    button2.setText("Confirm Item");
                    button1.setEnabled(false);
                    button3.setEnabled(true);
                    button4.setEnabled(true);
                    item2.setText("");
                    item3.setText("");
                    label2.setText("");
                    label3.setText("");
                    item2.setEditable(false);
                    item3.setEditable(false);
                } else {
                    // Execute when button is pressed
                    button1.setEnabled(true);
                    button2.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "Item #" + (myNum) + " accepted");
                    item2.setText("");
                    item3.setText("");
                    label2.setText("Enter CD ID for Item #" + (myNum + 1) + ":");
                    label3.setText("Enter quantity for Item #" + (myNum + 1) + ":");
                    label4.setText("Item #" + (myNum + 1) + " info:");
                    myNum++;
                    button1.setText("Process item #" + (myNum));
                    button2.setText("Confirm item #" + (myNum));
                }
            }
        });
        // View Order
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Execute when button is pressed
                System.out.println("View Order");
            }
        });
        // Finish Order
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Execute when button is pressed
                System.out.println("Finish Order");
            }
        });
        // New Order
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Execute when button is pressed
                System.out.println("New Order");
            }
        });
        // Quit
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // exit program

            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                MyClass c = new MyClass();
                c.pack();
                c.setVisible(true);

            }
        });
    }
}