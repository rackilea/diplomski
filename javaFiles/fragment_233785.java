int result;
while (true) {
    try {
        Scanner scan = new Scanner(System.in);
        input = scan.next();
        result = Integer.parseInt(input);
    } catch(Exception e) {
        System.out.println("Could not parse input, please try again.");
        continue;
    }

    if (result != 1 && result != 2) {
        System.out.println("Invalid input! Please select '1' or '2':");
    }
    else {
        break;
    }
}