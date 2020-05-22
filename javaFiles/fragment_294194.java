public class Geometric implements Seq {
    private double b;

    public Geometric(double a) {
        this.b=a;
    }

    @Override
    public double valAtIndex(int i){
        return Math.pow(b, i);
    }
}