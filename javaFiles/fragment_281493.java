public class SuperClass {

    public void method(){
        Objects.object.method();
    }

}

class SubClass extends SuperClass{

    @Override
    public void method(){
        System.out.println("I'm the sub class!");
    }

}

class Objects{

    public static SubClass object = new SubClass();
}