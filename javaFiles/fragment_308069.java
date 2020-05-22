public class MyObservable extends Observable{

    @Override
    public boolean hasChanged() {
        return true; //super.hasChanged();
    }

}