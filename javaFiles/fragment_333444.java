import java.util.ArrayList;
import java.util.List;

public class Example {
  public static void main(String[] args) {

    List<Clearance> clearances = new ArrayList<>();
    clearances.add(new Clearance("C-Tes"));
    clearances.add(new HighClearance("H-Test"));
    clearances.add(new Clearance("CC-Test"));
    clearances.add(new HighClearance("HH-Test"));

    System.out.println(peopleClearance(clearances));
  }

  // changed the parameter to List interface instead of ArrayList
  public static String peopleClearance(List<Clearance> clearances) {
    String names = "";
    for (Clearance c : clearances) {
      if (c instanceof HighClearance) {
        System.out.println(c.getName()); // tested using sysout statement, just prints ''
        names += c.getName();
      }
    }
    return names;
  }
}

class Clearance {
  private String name;

  public Clearance(String name) {
    super();
    this.name = name;
  }

  public String getName() {
    return name;
  }
}

class HighClearance extends Clearance {
   // if required!
  public HighClearance(String name) {
    super(name);
  }
}