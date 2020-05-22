public void createStudentRecord(Scanner in) {
    String inputStudentID = null;
    int inputMark = 0;

    while (true) {
        System.out.println("Enter Student ID: ");
        inputStudentID = in.nextLine();
        if (!(inputStudentID.length() == 6)) {
            System.out.println("Enter a student ID that is 6 characters");
        } else {
            break;
        }
    }

    while (true) {
        System.out.println("Enter Module Mark: ");
        inputMark = Integer.parseInt(in.nextLine());
        if (inputMark < 0 || inputMark > 100) {
            System.out.println("PLease enter a module mark between 0-100");
        } else {
            break;
        }
    }

    addStudent(inputStudentID, inputMark);
    System.out.println("\nNew student record has been successfully created.\n");
    countRecords();
}