private Student getStudentFromInput(Scanner input){
        System.out.println("Enter student full name ");
        String sName = input.nextLine();

        System.out.println("Enter student age ");
        int sAge = input.nextInt();

        System.out.println("Enter student id ");
        int sID = input.nextInt();
        input.nextLine();

      //  ... blah blah and so on right the way to the bit where you make the student
        Student studentInfo = new Student(sName, sAge, sID, sAddress, sCityStateZip, sGender);

        return studentInfo;
}