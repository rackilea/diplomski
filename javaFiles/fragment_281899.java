public class NumberGen {

    public int getRandom() {
        Random rand = new Random(); 
        return rand.nextInt(10) + 1;
    }
}