public class Ramses {
  public static void main(String[] args) {
    Gui gui = new Gui();  // variables should begin with lower-case letter
    // GuiObject.Gui();  // not needed
    SearchDB searchObject = new SearchDB(gui); // pass GUI object in
     // searchObject.searchDB(); // don't need this
  }
}