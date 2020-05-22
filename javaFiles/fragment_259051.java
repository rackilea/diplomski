class ValuedFruit implements Comparable<ValuedFruit> {
    private Fruit fruit;
    private double value;

    @Override
    public int compareTo(ValuedFruit o) {
        return (value < o.value) ? -1 : ((value > o.value) ? 1 : 0);
    }
}
List<ValuedFruit> fruits = new ArrayList<ValuedFruit>();
void sort(List<ValuedFruit> fruits){
    Collections.sort(fruits);
}