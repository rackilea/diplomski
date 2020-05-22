for (int i = 0; i < n; i++) {
   ...

  final int effectivelyFinal = i;
  jButton[i].addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent ae) {
      ...
      // use effectivelyFinal instead of i
    });
}