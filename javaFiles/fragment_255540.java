// Create a couple ArrayList objects and populate them
// with some delicious fruits.
Collection firstList = new ArrayList() {{
    add("apple");
    add("orange");
}};

Collection secondList = new ArrayList() {{
    add("apple");
    add("orange");
    add("banana");
    add("strawberry");
}};

// Show the "before" lists
System.out.println("First List: " + firstList);
System.out.println("Second List: " + secondList);

// Remove all elements in firstList from secondList
secondList.removeAll(firstList);

// Show the "after" list
System.out.println("Result: " + secondList);