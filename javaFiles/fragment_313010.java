private ArrayList<Student> readFile() throws FileNotFoundException {

        String fName = "p02-students.txt";

        Scanner scan = new Scanner(new File(fName));

        ArrayList<Student> studentList = new ArrayList<Student>();

        while (scan.hasNext()) {

             String studentType = scan.next();

            if (studentType.equals("C")) {
                studentList.add(readOnCampusStudent(scan));
            } else {
                studentList.add(readOnlineStudent(scan));
            }

            scan.nextLine();
        }

        scan.close();
        return studentList;
    }