public static void sortData(short days[], String name[]) {
    char choice;
    Scanner kd = new Scanner(System.in);

    System.out.println("a. Sort by Name\nb. Sort by Day");
    choice = kd.next().toCharArray()[0];

    switch (choice) {
    case 'a':
        // do something
        break;
    case 'b';
        // do something else
        break;
    }
}