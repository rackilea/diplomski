@Test
public void reuseFixedIteratorTest() {

    // MyList class from above goes here

    MyList myList = new MyList();
    Text first = new Text();
    Text second = new Text();

    Iterator<Text> iterator = myList.iterator();
    if (!iterator.hasNext()) return;
    first.set(iterator.next());
    while (iterator.hasNext()) {
        second.set(iterator.next());
        System.out.println("Out: " + first + " - " + second);
        first.set(second);
    }
}