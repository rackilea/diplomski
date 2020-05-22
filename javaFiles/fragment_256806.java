height = -1;
while (height < 0) {
    if (!scnr.hasNextInt()) {
        System.out.print("Please enter an integer value "
                + "(less than 2,147,483,648) as decimal digits: ");
    } else {
        height = scnr.nextInt();
        if (height < 0) {
           System.out.print("Please enter a positive integer value: ");
        }
    }
    scanner.nextLine();
}