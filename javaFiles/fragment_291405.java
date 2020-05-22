class MyClass implements Comparable<MyClass> {
    private double distance;
    private String name;

    @Override
    public int compareTo(MyClass other) {
        return Double.valueOf(this.distance).compareTo(other.distance);
    }

    ...
    getters and setters
    ...
}