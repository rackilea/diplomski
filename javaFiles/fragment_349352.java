public class OtherClass {
  public MainClass mainClass;

  public OtherClass(MainClass mainClass) {
    this.mainClass = mainClass;
  }

  public void someOtherClassMethod() {
     // now we can call methods with the MainClass reference
     mainClass.someMainClassMethod(); 
  }
}