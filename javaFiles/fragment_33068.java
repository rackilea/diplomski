JFrame Main = new JFrame();
    JLabel Label = new JLabel();
    Main.add(Label);
    Main.setVisible(true);
    Main.setResizable(false);
    Main.setBounds(0, 0, 480, 200);
    Main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Label.setText("Time Left: " + h + ":" + m + ":" + s + ".");
    Label.setFont(Label.getFont().deriveFont(48f));
    while(s > 0){
        s = (short) (s - 1);
        Label.setText("Time Left: " + h + ":" + m + ":" + s + ".");
        Thread.sleep(1000);
    }