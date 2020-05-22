public abstract class Box<T extends Mass> {
    abstract void putMassInBox(T mass);
}

public class CircleBox extends Box<CircleMass> {

    @Override
    void putMassInBox(CircleMass mass) {
    }   

}