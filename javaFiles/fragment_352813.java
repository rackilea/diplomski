public class MyClass{

  private static Logger logger = Logger.getLogger(MyClass.class);

  public ReturnType myMethod(Param p, Param2 p2) {
    ....
    ....
    try {
      ..    
    } catch(MyException e) {
       logger.log("Exceptions happen!", e); //this will put all the details in log file configured earlier
    }
    ....
  }

  ....
}