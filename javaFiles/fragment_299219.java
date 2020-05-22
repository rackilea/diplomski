// previous while loop here

flag = true; // resetting flag

while (flag) {
    System.out.println("Where do you live? [Contains 'Street']");
    String address = scan.nextLine();

    if (address.contains("Street")) {
        System.out.println("Proceed to the next step");
        // terminate the loop
        flag = false;
    } else {
        System.out.println("Please re-enter your address");
    }
}