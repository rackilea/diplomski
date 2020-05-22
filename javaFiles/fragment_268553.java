public abstract class Abbonement {
    public int getNiveau() {
        return 0;
    }
    ...

public class Milon extends Abbonement{

    @Override
    public int getNiveau() {
        return niveau;
    }
}