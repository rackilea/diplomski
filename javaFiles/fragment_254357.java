System.out.printf("How many classes are you taking?%n");
int classes = TextIO.getlnInt();
for(int class=1; class <= classes; class++) {
    System.out.printf("How many students are there in your %d class?%n", class);
    students += TextIO.getlnDouble();
}
double average = students / classes;
System.out.printf("There are on average %.2f students per class%n", average);