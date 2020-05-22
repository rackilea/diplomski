public abstract class Updater<T extends ParsedAnimal> {
    public abstract void updateItem(T parsed);
}
public class CatUpdater extends Updater<ParsedCat> {
    @Override
    public void updateItem(ParsedCat parsed) {}
}
public class DogUpdater extends Updater<ParsedDog> {...}