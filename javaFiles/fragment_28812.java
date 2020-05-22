public class WeigherFactory{

   public static <P extends Plant> PlantWeigher<P> getInstance(P plant){
    // should return a correct Weigher for the subttype of Plant P
            return ...
  }
}