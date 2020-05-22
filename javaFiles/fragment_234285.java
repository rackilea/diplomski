while (true) {
    if (scanner.hasNextInt()) {
        j = scanner.nextInt();
        break;
    } else {
        // Consume the wrong input
        scanner.next();

        System.out.println("Please enter a valid number");        
    }
}