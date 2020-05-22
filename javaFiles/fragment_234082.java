public class ObjectOne extends Thing {
  public String objectString()
  {
      return "objectString() of class ObjectOne\n" ;
  }
}

public class ObjectTwo extends Thing {
  public String objectString()
  {
    return "objectString() of class ObjectTwo\n" ;
  }
}

public class ObjectThree extends Thing {
  public String objectString()
  {
    return "objectString() of class ObjectThree\n" ;
  }
}

public abstract class Thing implements SuperObject {
  public String alwaysTheSame() {
    return "The same thing";
  }
}

public interface SuperObject {
  public String objectString();

  public String alwaysTheSame();
}

import static java.lang.System.out ;

public class ControlClass {

  public static void main(String[] args)
  {
    SuperObject [] arr = {new ObjectOne(), new ObjectTwo(), new ObjectThree()} ;

    for(SuperObject elem : arr)
    {
        out.println(elem.alwaysTheSame());
        out.println(elem.objectString()) ;
    }
  }
}