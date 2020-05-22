// number of times you want to add elements (1, 2, 3)
    int timesToRepeat = 2;

    // your ArrayList instance
    ArrayList<Integer> a1 = new ArrayList<Integer>();

    // use add() to add the integer elements 1, 2, 3
    a1.add(1);
    a1.add(2);
    a1.add(3);

    // clone a1 so we have a non-changing copy of it when we get to our for loop
    ArrayList<Integer> a1copy = (ArrayList<Integer>) a1.clone();

    // here's where it will take the three elements (1, 2, 3) from a1copy
    // it will repeatedly add them to a1 as many times as you specified
    // you specify this number when setting the int variable timesToRepeat
    for (int i = timesToRepeat; i > 1; --i) {
        a1.addAll(a1copy);

    }

    // print your ArrayList
    System.out.println(a1);