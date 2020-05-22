public class Aclass {
    public boolean Afunction() {
         String result = doBfunction();
         // do stuff with result
         return true;
    }
    // This is your "extracted" method.
    protected doBfunction() {
        return Bclass.Bfunction();
    }
}