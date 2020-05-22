import java.util.ArrayList;

class Bird
{
  public void fly(int x) {
     System.out.println("Flew "+x+" meters");
  }
}

class DumbBird extends Bird
{
   public void fly(int x) {
     x-=5; //we're dumb
     System.out.println("Flew "+x+" meters");
   }

   public void sing() {
      System.out.println("La la la!");
   }
}

class Test {
    public static void main(String[] args)  {
       ArrayList<Bird> cage = new ArrayList<Bird>();
       cage.add(new Bird());
       cage.add(new DumbBird());
       cage.add(new Bird());
       cage.add(new DumbBird());
       cage.add(new SleepyBird());

       ((DumbBird) cage.get(1)).sing();
    }
}