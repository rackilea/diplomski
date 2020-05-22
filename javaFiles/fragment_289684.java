ArrayList<Kaart> thand = uno.gethSpeler().getHand();

for(int i=0; i < thand.size(); i++) {
  final int copy = i;
  btnArr[i].setIcon(thand.get(i).getImg());

  btnArr[i].addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      iKaart = copy;
    }
  });
}