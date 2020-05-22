public class CustomMethodHandler implements MethodHandler {

    private MyEntity objectBeingProxied;
    private MyFieldType myCustomField;

    public CustomMethodHandler(MyEntity entity) {
       this.objectBeingProxied = entity;
    }

    // code here with the implementation of MyCustomInterface
    // handling the entity and your customField

    public Object invoke(Object self, Method method, Method proceed, Object[] args) throws Throwable {
          String methodName = method.getName();

          if(methodNameFromMyCustomInterface(methodName)) {
            // handle methodCall internally: 
            // you can either do it by reflection
            // or if needed if/then/else to dispatch
            // to the correct method (*) 
          }else {
             // it's just a method from entity let them
             // go. Notice we're using proceed not method!

             proceed.invoke(objectBeingProxied,args);
          }
    }
  }