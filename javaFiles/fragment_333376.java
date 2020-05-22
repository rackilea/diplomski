public class Human{

    //now, I define three attributes for the class Human 
    //two of them are variable 
    private int age;
    private String name;

    //another one is a constant
    public final boolean isIntelligent=true;

    public int getAge(){
       return age;
    }

    public int getName(){
       return name;
    }


    public void sayHello(){
       //here hello is a variable, means it can be assigned a value for many times
       String hello="";
       if(age>3){
           hello="hello world"//we assign "hello world" to this variable 
       }
       else{
           hello="awuawuau";//baby does not know hello, so we assign another one 
       }

      System.out.println(hello);
    }
}