public class SubClass extends SuperClass{

public static void method2(){
  //do Something
}

@Override
public void method(){
  Subclass.method2();
}

}