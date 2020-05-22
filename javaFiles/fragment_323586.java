double smallest;
for (int i = 0; i < SIZE; i++) {
    System.out.print("Enter the mark: ");
    marks[i] = kb.nextDouble();

    if (i == 0) {
        smallest = marks[0];
    }
    if (marks[i] < smallest) {
        smallest = marks[i];
    }
}