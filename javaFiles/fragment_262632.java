class MyActionListener implements ActionListener{

    ArrayList<JButton> buttonList;
    public MyActionListener(ArrayList<JButton> a) {
        buttonList = a;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        for(JButton jb: buttonList) {
            jb.setText("X");
        }
    }
}


class One {
    MyActionListener buttonListener;
    ...
    public void GamePlay() {
    ...
        if(s.equals("HUMAN")) {
            buttonListener = new MyActionListener(myB);
            for(JButton B1 : myB) {
                B1.addActionListener(buttonListener);
        }
    ...
    }