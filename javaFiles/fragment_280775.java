final List<Object1> firstList = new List<>();
final List<Object2> secondList = new List<>();

// ...

public Object readFromListOne() {
  synchronized(firstList) {
    return firstList.remove(0);
  }
}

public Object readFromListTwo() {
  synchronized(secondList) {
    return secondList.remove(0);
  }
}