void setup() {
  try {
    Class<Wtf> c = Wtf.class;
    IMenuRunnable u = (IMenuRunnable) c.newInstance();
    println(u.toString());
  }
  catch(Exception e) {
    e.printStackTrace();
  }
}

interface IMenuRunnable {}

public class Wtf implements IMenuRunnable{ 
  public Wtf() {
  }
}