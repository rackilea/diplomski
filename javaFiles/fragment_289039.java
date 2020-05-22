class Developer{
    public writeCode{
         System.out.println("Supervisor will write the code here");
    }
}

class JrDeveloper extends Developer{
    @Override
    public writeCode{
         System.out.println("Jr.Developer will write code");
    }
}

class Test{

     public static void main(){
     Developer dev = new JrDeveloper();
     dev.writeCode();         // Do you really expect the Developer to write 
                              // the code or the Jr.Developer?
     }
}