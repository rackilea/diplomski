List<MyClass> myVector = new Vector<MyClass>();

myVector.add(myClass1);
myVector.add(myClass2);
myVector.add(myclass3);


Collections.sort(myVector, new Comparator<MyClass>() {
    public int compare(MyClass one, MyClass two) {
        return Double.valueOf(one.getDistance()).compareTo(two.getDistance());
    }
});