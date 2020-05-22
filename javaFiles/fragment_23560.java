public abstract class PersonController extends MultiActionController {

    /**
      * code as shown above
      */

    @Override
    public Object newCommandObject(Class clazz) thorws Exception {
        if(clazz.isAssignableFrom(Person.class)) {
            return newPerson();
        }
    }                          

    public abstract Person newPerson();
}