public class App {
  int i = 0;
  int j;

  public App() {
    int i = 2; // This i is a local variable in the constructor
    j = i;
  }
}