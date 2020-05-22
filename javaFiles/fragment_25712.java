public static class Person {

    private StringProperty name;
    private DoubleProperty progressBar;

    private Person() {
       name = new SimpleStringProperty();
       progressBar = new SimpleDoubleProperty();
    }

    public Person(String name, double surname) {
        this.name = new SimpleStringProperty(name);
        this.progressBar = new SimpleDoubleProperty(surname);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public double getProgressBar() {
        return progressBar.get();
    }

    public void setProgressBar(double surname) {
        this.progressBar.set(surname);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public DoubleProperty progressBarProperty() {
        return progressBar;
    }
}