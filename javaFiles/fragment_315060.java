public void init(){
cgp = new CardGamePanel();
JPanel panel2 = new JPanel();
panel2.add(btnD);
btnD.addActionListener(new ActionListener(){

    public void actionPerformed(ActionEvent e){
        cgp.go(panel2.getGraphics());
    }
});
  add(cgp, BorderLayout.CENTER);
  add(panel2, BorderLayout.SOUTH);
  setSize(500,500);
}