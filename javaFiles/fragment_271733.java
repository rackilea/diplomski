Random r = new Random();
int min = 101;    // assign max value 101 before loop

for(int i = 0; i < 20; i++) {
    int number = r.nextInt(101);
    System.out.println("Number " + i + ": " +  number);
    if (number < min) {
        min = number;
    }
}
System.out.println(min);