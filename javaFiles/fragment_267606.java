public class Zombie
{
   private final Gui guiThatMadeMe;

   public Zombie(Gui owner)
   {
      guiThatMadeMe = owner;
   }

   ....

   public void move()
   {
      Survivor guy = guiThatMadeMe.getSurvivor();

      // Do whatever you need to with the survivor
   }
}


public class Gui
{
   private Survivor lonelyGuy;

   ... 

   public Survivor getSurvivor()
   {
      return lonelyGuy;
   }

   public void createNewGame() // I'm guessing you have some method like this
   {
       lonelyGuy = new Survivor();
       for (int i = 0; i < NUM_ZOMBIES; i++)
       {
          Zombie zombie = new Zombie(this); // pass in this reference
          // Do something with the zombie
       }
       // other setup
   }
}