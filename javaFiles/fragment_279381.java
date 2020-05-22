package com.ggl.testing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class IsPrimeNumber implements Runnable {

    private DefaultListModel<Integer> primeRangeModel;
    private DefaultListModel<Integer> primeFactorModel;

    private JLabel message;

    private JList<Integer> primeRangeList;
    private JList<Integer> primeFactorList;

    private JTextField input;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new IsPrimeNumber());
    }

    public IsPrimeNumber() {
        this.primeRangeModel = new DefaultListModel<Integer>();
        this.primeFactorModel = new DefaultListModel<Integer>();
    }

    @Override
    public void run() {
        JFrame frame = new JFrame("isPrime");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        JPanel numberPanel = new JPanel();
        numberPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        numberPanel.setLayout(new BoxLayout(numberPanel, BoxLayout.PAGE_AXIS));

        JLabel title = new JLabel();
        title.setText("Enter a number, then press Enter");
        numberPanel.add(title); // adds title

        input = new JTextField();
        input.addActionListener(new PrimeActionListener());
        numberPanel.add(input);

        message = new JLabel(" ");
        message.setForeground(Color.RED);
        numberPanel.add(message);

        mainPanel.add(numberPanel);
        mainPanel.add(Box.createVerticalStrut(10));

        JPanel primeRangePanel = new JPanel();
        primeRangePanel.setBorder(BorderFactory
                .createTitledBorder("Prime Range"));

        primeRangeList = new JList<Integer>(primeRangeModel);
        JScrollPane primeRangeScrollPane = new JScrollPane(primeRangeList);
        primeRangePanel.add(primeRangeScrollPane);

        mainPanel.add(primeRangePanel);

        JPanel primeFactorPanel = new JPanel();
        primeFactorPanel.setBorder(BorderFactory
                .createTitledBorder("Prime Factors"));

        primeFactorList = new JList<Integer>(primeFactorModel);
        JScrollPane primeFactorScrollPane = new JScrollPane(primeFactorList);
        primeFactorPanel.add(primeFactorScrollPane);

        mainPanel.add(primeFactorPanel);

        frame.add(mainPanel);

        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public class PrimeActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            clearModels();
            int start = 2;
            int end = 0;
            try {
                end = Integer.parseInt(input.getText().trim());
                if (end <= 1) {
                    throw new RuntimeException();
                }
                primeRanges(start, end);
                primeFactors(end);
                message.setText(" ");
            } catch (NumberFormatException a) {
                message.setText("Not a valid number, try again :(");
            } catch (RuntimeException r) {
                if (end >= 0) {
                    message.setText("There are no prime numbers below 2 :(");
                } else {
                    message.setText("You cannot use negative numbers :(");
                }
            }
        }

        private void clearModels() {
            primeRangeModel.clear();
            primeFactorModel.clear();
        }

        private void primeRanges(int start, int end) {
            for (int i = start; i <= end; i++) {
                if (isPrime(i)) {
                    primeRangeModel.addElement(i);
                }
            }
        }

        private void primeFactors(int end) {
            for (int i = 2; i <= end; i++) {
                while (end % i == 0) {
                    primeFactorModel.addElement(i);
                    end /= i;
                }
            }
        }

        private boolean isPrime(int num) {
            if (num % 2 == 0 && num != 2) {
                return false;
            }

            for (int i = 3; i * i <= num; i += 2) {
                if (num % i == 0) {
                    return false;
                }
            }

            return true;
        }
    }
}