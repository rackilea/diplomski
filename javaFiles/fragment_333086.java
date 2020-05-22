public interface YapSound{
     String     doYapSound();
}

public class HappySound implements YapSound{

    @Override
    public String doYapSound() {
          return "happy";
     }

}

public class SadSound implements YapSound{

    @Override
    public String doYapSound() {
        return "sad";
    }

}

public class Arf {
    YapSound yap;
    public Arf(YapSound yap) {
        this.yap = yap;
    }

    public String woof() {
        /*
         * Should select which doYapStuff() based on whether T
         * happens to be an Integer, or something else.
         */
        return yap.doYapSound();
    }


}

public static void main(String[] args) {

    Arf arf1 = new Arf(new HappySound());
    System.out.println(arf1.woof()); // Should print "happy"

    Arf arf2 = new Arf(new SadSound());
    System.out.println(arf2.woof()); // Should print "sad"
}