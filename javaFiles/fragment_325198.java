public class EvilManager {
   private Employee emp; // reference to it can be changed from anywhere within the class (or even outside if you change access modifier)

   public void initEmployee() {
      emp = new Employee("1", 0);
   }

   public void replaceWithZombie(Employee e) {
      emp = new Employee("2", 0); // reference changed
   }
}