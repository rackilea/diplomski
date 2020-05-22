public Class CalculatorController
{
   private ICalculator calculator; //interface to a calculator object

   // Add the other variables such as the textField, etc.

   public void onCalculateClicked(ActionEvent event)
   {
        String expressionToCalculate = textField.getText();
        String solution = calculator.calculate(expressionToCalculate); // this is the function in the ICalculator interface
        solutionLabel.setText(solution);

   }

   public void setCalculator(ICalculator calculator)
   {
       this.calculator = calculator;
   }

}