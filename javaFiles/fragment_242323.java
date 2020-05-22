@When("the user clicks the button (\\d+) times")
public void theUserClicksTheButton(int howOften) {
  for (int i = 0; i < howOften; i++) {
    // do stuff for one click here
  }
}