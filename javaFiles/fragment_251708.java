int loc = 0;
    System.out.println("Unsorted List");
    for(int a : randomNumbers) {
        if (searchNumber == a) {
            System.out.println(searchNumber + " found at location: "+ loc);
        }
        loc++;
    }
    Collections.sort(randomNumbers);

    loc = 0;
    System.out.println("Sorted List");
    for(int b : randomNumbers) {
        if (searchNumber == b) {
            System.out.println(searchNumber + " found at location: " + loc);
        }
        loc++;
    }