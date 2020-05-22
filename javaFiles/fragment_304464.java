public class Utils () {
   private static Random random;

   private Utils(){}  //Only static methods

   public static final Random getRandom() {
       if(random == null) random = new Random();
       return random;
   }

   public static final seedRandom(long seed) {
       random = new Random(seed);
   }