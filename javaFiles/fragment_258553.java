public class GenericTypeData<T> {

    private final T a;

    public GenericTypeData(T a) {
        this.a = a;
    }

    public static void main(String[] args) {
          GenericTypeData<String> string = new GenericTypeData<String>("am a String");
          GenericTypeData<Integer> intType = new GenericTypeData<Integer>(122);
    }

}