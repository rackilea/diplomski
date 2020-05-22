do {
    try {
        System.out.print("Enter the number of students: ");
        students = input.nextInt();
    } catch (InputMismatchException e) {
        System.out.print("Invalid number of students. ");
    }
    input.nextLine(); // clears the buffer
} while (students <= 0);