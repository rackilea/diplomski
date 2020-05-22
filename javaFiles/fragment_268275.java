public abstract class AbstractAnimalBuilding {
    ...
    public abstract void accept(AnimalBuildingVisitor v);
}

public interface class AnimalBuildingVisitor<T> {

    public T visit(AnimalBuildingA a);
    public T visit(AnimalBuildingB b);
    ...
}