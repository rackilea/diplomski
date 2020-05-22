class Animal
   {
     // This method will be overridden by Dog, Wolf and Cat classes.
     makesound(){
              System.out.println("make sound");  }
  }


 class Dog extends Animals
    {
     makesound()
              {System.out.println("Bau");}
    }

class Cat extends Animals
    {
     makesound(){System.out.println("Miao");}
    }

class Wolf extends Animals
   {
     makesound(){System.out.println("Uuuu");}
   }


class MyMain
  {
     public static void main(String args[])
     {
      /* This is where polymorphism happens, although A[0],A[1],A[2] are all Animals, 
         at run-time we realize that A[0] is infact dog, A[1] is cat and A[2] is wolf
         so when call makesound on these objects, the method behaves differently so the
         name polymorphism.*/ 

     Animals[] A=new Animals[3];
     A[0]=new Dog();         
     A[1]=new Cat();         
     A[2]=new Wolf();
     for(int i=0;i<3;i++)
       A[i].makesound();
     }