// value = sc.nextDouble();
while (!sc.hasNextDouble()) // <-- while we don't have a double
    {
        sc.nextLine();

        System.out.println("Enter a valid value: ");
        // value = sc.nextDouble();
    }
value = sc.nextDouble(); // <-- here