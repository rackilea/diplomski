public class TestProgram {


    public void method(Object o)
    {
        System.out.println("Object Verion");
    }
    public void method(String s)
    {
        System.out.println("String Version");
    }


      public static void main(String args[])
       {
          TestProgram question = new TestProgram();
          question.method(question);
       }
    }