public class Eggs {
  public static void main(String[] args) {
    Dozens [] da = new Dozens[3]; //one array object created
    da[0] = new Dozens(); // one Dozens object created
    Dozens d = new Dozens(); //one Dozens object created
    da[1] = d; 
    d = null; //nothing available for gc here, as there is still a referrence to that Dozens object (da[1])
    da[1] = null; //da[1] available for gc
    // do stuff
  }
}