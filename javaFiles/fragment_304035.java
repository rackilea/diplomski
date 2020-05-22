public class Test{

    public static void main(String args[]){
        //All of this code is inside a for loop
        Class1 cl1=new Class1("TestString1");
        Class2 cl2=new Class2("TestString2");

        //note we can just communicate now, no interface
        cl1.giveString(cl2.string);


        //but we can also communicate using the interface
        giveStringViaInterface(cl2,cl1);
    }

    //any class that extended SomeInterface could use this method
    public static void giveStringViaInterface(SomeInterface from, SomeInterface to){
        to.giveString(from.getString());
    }



}