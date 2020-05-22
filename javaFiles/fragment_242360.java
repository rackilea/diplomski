// in your "i" loop
final int row = i; // must be final to be used inside the anonymous class
final ButtonGroup btnG = bg;
final String answerAction = "" + ranNumber; // hard to tell if this is what you mean
ActionListener listener = new ActionListener() {
  public void actionPerformed(ActionEvent e) {
    System.out.println("row " + row);
    String selectedAction = btnG.getSelection().getActionCommand();
    System.out.println("btn " + selection);
    boolean isCorrectForThisRow = (answerAction == selectedAction);
    System.out.println("is correct: " + isCorrectForThisRow);
  }
};
// in your "j" loop, with either the answerLetter or k buttons
// as required
k.setActionCommand("" + j);
k.addActionListener(listener);