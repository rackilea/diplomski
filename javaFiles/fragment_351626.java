private List<T> errors = new ArrayList<T>();

    public void addError(T t) {
        errors.add(t);

    }

public List<T> getErrors() {
        return errors;
    }