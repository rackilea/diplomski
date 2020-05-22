interface MyOperation{
   public ResultClass execute(MyArgumentClass argument);
}

public class Method1 implements MyOperation {
    public ResultClass execute(MyArgumentClass argument){
      ....
    }
}

public class Method176 implements MyOperation {
    public ResultClass execute(MyArgumentClass argument){
      ....
    }
}

public class DoIt{
    public ResultClass doIt(MyOperation method, MyArgumentClass argument){
       return method.doIt(argument);
    }
}