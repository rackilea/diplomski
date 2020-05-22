public abstract class Boss{
    public abstract int getX();
    public abstract int getY();
    public abstract int getZ();
}

public class Level1Boss extends Boss{
    ... (implement the abstract methods)
}

public Boss getBoss(){
    ...
}