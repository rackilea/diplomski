@After("call(* java.lang.reflect.Field.set(..)) && args(obj, value) && target(target)")
    public void webelementInit(JoinPoint jp, Object obj, Object value, Field target) {
        //obj - instance of a class (page object) that declares current field
        //value - new field value (instantiated WebElement)
        //field - current field
        //you can filter calls to the fields you need by matching target.getDeclaringClass().getCanonicalName() with page object's package
        //for example:
        //if(target.getDeclaringClass().getCanonicalName().contains("com.example.pageobjects")) {
            //do stuff
        //}
    }