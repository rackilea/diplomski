System.out.println("Unsorted List");
    for (int i = 0; i < randomNumbers.size(); i++) {
        if (randomNumbers.get(i) == searchNumber) {
            System.out.println(searchNumber + " found at location: " + i);
        }
    }
    Collections.sort(randomNumbers);

    System.out.println("Sorted List");
    for (int i = 0; i < randomNumbers.size(); i++) {
        if (randomNumbers.get(i) == searchNumber) {
            System.out.println(searchNumber + " found at location: " + i);
        }
    }