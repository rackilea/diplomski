boolean exception;

do {
    exception = false;
    try {
        System.out.println("enter initial balance");
        bal = scan.nextDouble();
    } catch (Exception e) {
        exception = true;
        scan.next(); //discard the input
    }
} while (exception);