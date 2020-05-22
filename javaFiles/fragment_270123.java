final int total = 15;
String[] firstNames = new String[total];
String[] lastNames = new String[total];

try (Scanner scan = new Scanner(new File("file"))) {
    for (int i = 0; i < total; i++) {
        firstNames[i] = scan.next();
        lastNames[i] = scan.next();
    }
}

// firstNames: Max, Stephen, Agatha
// lastNames: Frei, King, Christie