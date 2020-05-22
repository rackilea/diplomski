@Test(expected=Calculator.CalcError.class)
public void testDivision() throws Calculator.CalcError {
    Calculator myCalc = new Calculator(10, 0);
    myCalc.setOperation(Calculator.Operation_e.DIVIDE);
    myCalc.getResult();
}