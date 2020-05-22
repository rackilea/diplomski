public class ParentClazz{
        String someVar;
    public ParentClazz(){
        someVar="test";
    }
    public ParentClazz(String someVar){
        System.out.println("I have been invoked");
        this.someVar=someVar;
    }
}