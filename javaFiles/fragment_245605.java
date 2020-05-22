public class Notification<T> {
    private List<String> errors = new ArrayList<>();
    private T model; // model for which the notifications apply

    public Notification<T> pushError(String message) {
        this.errors.add(message);
        return this;
    }

    public boolean hasErrors() {
        return !this.errors.isEmpty();
    }

    public void clearErrors() {
        this.errors.clear();
    }

    public String getFirstError() {
        if (!hasErrors()) {
            return "";
        }
        return errors.get(0);
    }

    public List<String> getAllErrors() {
        return this.errors;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }
}