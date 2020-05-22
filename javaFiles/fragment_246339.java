public class GUI extends javax.swing.JFrame {
    Thread updateThread = null;
    public GUI() {
        JButton btnStart = new JButton("Start");
        JButton btnStop = new JButton("Stop");
        JPanel jPanel = new JPanel();
        jPanel.setBounds(0, 0, 100, 200);
        jPanel.add(btnStart);
        jPanel.add(btnStop);
        add(jPanel);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            System.out.println("Work updated");
                            try {
                                Thread.sleep(1000);//Time to wait for next routine
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                updateThread.start();
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateThread.stop();

            }
        });
        setVisible(true);
        setBounds(0, 0, 100, 200);
    }

    public static void main(String[] args) {
        new GUI();
    }

}