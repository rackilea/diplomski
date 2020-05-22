public static int scanaverage() {
    System.out.println("Enter any number, type 'END' to exit");
    Scanner input = new Scanner(System.in);
    int total = 0;
    int count = 0;
    String line;
    do {
        line = input.nextLine();
        try {
            total += Integer.parseInt(line); // Cast the number, if it does not succeed catch the exception.
            count += 1;
        } catch(NumberFormatException e) {
            if(!line.equalsIgnoreCase("end")) { // Wrong input
                System.out.println("Wrong input, input another number or end");
            }
        }
    } while (!line.equalsIgnoreCase("end"));
    return total / count;
}