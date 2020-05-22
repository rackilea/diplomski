package bench;

import org.openjdk.jmh.annotations.*;

import java.lang.reflect.Array;

@State(Scope.Benchmark)
public class Generics {
    private ObjectArray<String> objectArray;
    private GenericArray<String> genericArray;
    private StringArray stringArray;
    private int index;

    @Param("100000")
    private int length;

    @Setup
    public void setup() {
        genericArray = new GenericArray<>(String.class, length);
        objectArray = new ObjectArray<>(length);
        stringArray = new StringArray(length);

        for (int i = 0; i < length; i++) {
            String s = Integer.toString(i);
            objectArray.set(i, s);
            genericArray.set(i, s);
            stringArray.set(i, s);
        }
    }

    @Benchmark
    public String getGenericArray() {
        return genericArray.get(nextIndex());
    }

    @Benchmark
    public String getObjectArray() {
        return objectArray.get(nextIndex());
    }

    @Benchmark
    public String getStringArray() {
        return stringArray.get(nextIndex());
    }

    @Benchmark
    public void setGenericArray() {
        genericArray.set(nextIndex(), "value");
    }

    @Benchmark
    public void setObjectArray() {
        objectArray.set(nextIndex(), "value");
    }

    @Benchmark
    public void setStringArray() {
        stringArray.set(nextIndex(), "value");
    }

    private int nextIndex() {
        if (++index == length) index = 0;
        return index;
    }

    static class GenericArray<T> {
        private T[] data;

        @SuppressWarnings("unchecked")
        public GenericArray(Class<T> type, int length) {
            this.data = (T[]) Array.newInstance(type, length);
        }

        public T get(int index) {
            return data[index];
        }

        public void set(int index, T value) {
            data[index] = value;
        }
    }

    static class ObjectArray<T> {
        private Object[] data;

        public ObjectArray(int length) {
            this.data = new Object[length];
        }

        @SuppressWarnings("unchecked")
        public T get(int index) {
            return (T) data[index];
        }

        public void set(int index, T value) {
            data[index] = value;
        }
    }

    static class StringArray {
        private String[] data;

        public StringArray(int length) {
            this.data = new String[length];
        }

        public String get(int index) {
            return data[index];
        }

        public void set(int index, String value) {
            data[index] = value;
        }
    }
}