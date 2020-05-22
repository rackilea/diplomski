public class MyListener implements Listener<String, Integer>{

    @Override
    public <T> Listener<T, Integer> get() {
        return convert to T and return a new instance of Listener...;
    }

}