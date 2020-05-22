public class ScenarioA {

  public static String getVariableYouWantToUse() {
    return variableYouWantToUse;
  }

  private static String variableYouWantToUse;

  Given("your step that expects one parameter")
  public void some_step(String myVariable)
    variableYouWantToUse = myVariable;
}