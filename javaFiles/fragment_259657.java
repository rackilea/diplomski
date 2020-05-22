class OperatorAction implements ActionListener
{
    private int operator;
    private SimpleCalc calc;

    public OperatorAction(SimpleCalc c, int operation)
    {
        calc = c;
        operator = operation;
    }

    public void actionPerformed(ActionEvent event) {
      calc.setCurrentCalc(Integer.parseInt( 
          ((JTextField)event.getSource()).getText()));
      calcOperation = operator;
    }
}