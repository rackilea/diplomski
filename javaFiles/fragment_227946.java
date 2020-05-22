public class Velocity extends BaseVector<Velocity> {


    public Velocity(int x, int y, int z) {

        super(x, y, z);
    }


    @Override
    protected Velocity createNew(int x, int y, int z) {

        return new Velocity(x, y, z);
    }

}