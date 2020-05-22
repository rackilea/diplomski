void setup() {
  try {

    Class<?> sketchClass = Class.forName("sketch_150702a");
    Class<?> innerClass = Class.forName("sketch_150702a$Wtf");

    java.lang.reflect.Constructor constructor = innerClass.getDeclaredConstructor(sketchClass);

    IMenuRunnable u = (IMenuRunnable)constructor.newInstance(this);
    println(u.toString());
  }
  catch(Exception e) {
    e.printStackTrace();
  }
}

interface IMenuRunnable {
}

public class Wtf implements IMenuRunnable { 
  public Wtf() {
  }
}