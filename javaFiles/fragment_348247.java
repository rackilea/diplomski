public class Lib1{
    public static Lib1 instance = new Lib1();

    public double getMagicRandomNumber() {
        double advancedRandomNumber = 15;
        return advancedRandomNumber;
    }

   //Bridge to access Stuff from jar 2
   public double getExtraMagicRandomNumber()
   {
        return Lib2.instance.getRandomNumber();
   }
}