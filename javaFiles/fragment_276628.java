public class A {
    int variable = 0; 
}

public class Demo extends A{

}

public void testDowncast(){
    Demo myClass = new Demo();
    myClass.variable = 2;
    A morphingTime = myClass;
    System.out.println("And now Power Ranger Demo has turned into Mighty A:");
    System.out.println("I am: "+morphingTime.getClass() + " and my variable is: " + morphingTime.variable);
}