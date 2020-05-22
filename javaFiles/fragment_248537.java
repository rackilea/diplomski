public static void main(String[] args) {
    MyList anInstance = new MyList(); // creates an instance of the MyList class
    // note that at this point, the instance is created, but because there is no constructor method, the fields (head, tail) are both null

    String someValue = "A list element";
    anInstance.add(someValue); // add an element to the list
    // if you step through the add method, you'll see that the value coming in is a String ("A list element"), but nothing has been initialized yet (head, tail are both null)
    // So you'd go to the "else" bit of the logic in the add method, which initializes the head and tail element to the same object that you passed in.  So now your list contains one item ("A list element");

    String anotherValue = "Another value";
    anInstance.add(anotherValue); // add a second element to the list
    // now the path through the add method is different, because your head and tail elements have been initialized, so set the tail.next value to the new element, and then have tail be this new value.
    // so the head is "A list element" and the tail is "Another value" at this point, and the head's next field is "Another value" (this is the linking part of a linked list)

    // from here, you could add more elements, or you could remove elements.  The remove method is pretty straight forward as well -- it removes from the front of the list (note the part of the code that returns the head, and then updates the head value to point to the next item in the list.

}