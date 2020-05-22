public class  SampleEquation implements EquationInterface {

    public JPanel createParameterPanel(){return null;}

    public void performSolve(){
    //solving an equation
    }

    private String equationName = "MyDefaultEquationName";// or = null

    public void setEquationName(String equationName){
      this.equationName = equationName;
    }

    public String getEquationName(){
      return this.equationName;
    }
}