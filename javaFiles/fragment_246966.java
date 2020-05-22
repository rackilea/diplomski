package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutionException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class MyClass extends JFrame {
    private JLabel loading;
    private JButton jButton;
    private JPanel jPanel;

    public static void main(String[] args) {
        new MyClass();
    }

    MyClass() {
        jPanel = new JPanel();
        setLayout(new GridLayout(0, 1));
        loading = new JLabel("");
        loading.setVisible(true);

        jButton = new JButton("Click me!");
        addActionToJButon();

        setSize(300, 300);
        jPanel.add(jButton);
        jPanel.add(loading);

        add(jPanel);

        setVisible(true);
    }

    private void addActionToJButon() {
        jButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                loading.setText("Loading....");

                swingWorker();
            }
        });
    }

    private void swingWorker() {
        SwingWorker worker = new SwingWorker<String, String>() {

            @Override
            protected String doInBackground() throws Exception {
                // TODO Auto-generated method stub
                for (int i = 0; i <= 1000000; i++) {
                    System.out.println(i);
                }
                return "Done";
            }

            protected void done() {
                try {
                    String finished =  get();
                    loading.setText(finished);
                } catch (InterruptedException | ExecutionException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
        worker.execute();
    }
}