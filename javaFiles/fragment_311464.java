//input user number
System.out.print("Please enter a number: ");

do {
    try {
        num = input.nextInt();
    } catch (Exception e) {
        break;
    }
    // call methods
    isEvenResult = app.isEven(num);

    if (isEvenResult) {
        System.out.printf("%d is even", num);
    } else {
        System.out.printf("%d is odd", num);
    }
} while (true);