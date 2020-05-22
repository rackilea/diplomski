start.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent e){
    temp = pullInfo(txtOrder, txtRounds);
    int rounds = temp.get(0);
    temp.remove(0);
    ArrayList<Integer> order = temp;
    connect(order, rounds);
  }
});