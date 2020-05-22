public class StatementProxy {

    public StatementProxy(Object anObject) {
        super(anObject);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {               
       try {
           return method.invoke(proxy, args);
       } catch (SQLException sqle) {
           if (method.getName().contains("execute")) {
              String sql = "";

              if (args != null && args[0] != null) {
                  sql = args[0].toString();
              }

              saveToFile(arg);
           }

           throw sqle;   
        }
    }
}