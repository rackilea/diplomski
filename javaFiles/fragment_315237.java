public class Validation<T>
    private final T value;
    private boolean valid = true;

    public Validation(T value) {
        this.value = value;
    }

    public Validation<T> greaterThan(Comparable<T> another) {
        if(valid) {
            valid = another.compareTo(value) < 0;
        }        
        return this;
    }

    public boolean isValid() {
        return valid;
    }

    //Other validation methods here...
}