public class StoreObject<T extends BaseObject> {
    public T object = null;
    // alternatively: public BaseObject object = null;
    // that will allow for object to be any subclass of BaseObject
    public ArrayList<T> list = null;
}