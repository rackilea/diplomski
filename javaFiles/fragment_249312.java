int count = 3;

while (count > 0 && !scan.hasNextInt()) {
    System.out.println("Please enter an integer answer");
    System.out.println("You have " + (count - 1) + "more chances left.");
    count--;
    scan.next();
}

if (count > 0) {
    return scan.nextInt();
}

return -1;