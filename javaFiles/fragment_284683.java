public class Test
  {

    public static void main(String[] args)
    {
      Sub sub = new Sub();
      Thread t = new Thread(sub::printInstanceCreatedClassName);
      t.start();
    }
  }


  public class Sub
  {
    private String createdClassName;

    public Sub(){
      StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
      createdClassName =  stackTraceElements[2].getClassName();
    }

    public void printInstanceCreatedClassName(){
      System.out.println(createdClassName);
    }
  }