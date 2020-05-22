public void addButtons(JPanel panel) {
   for (int k = 0; k < SIZE; k++) {
      for (int j = 0; j < SIZE; j++) {
         buttons[k][j] = new JButton(k + 1 + ", " + (j + 1));
         panel.add(buttons[k][j]);
      }
   }
}