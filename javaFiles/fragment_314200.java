public static void main(String args[]) {

    File studentFile = new File("students.txt");
    Scanner scanner = null;

    try {
        scanner = new Scanner(studentFile).useDelimiter("\n");
    } catch (FileNotFoundException e) {System.exit(1);}

    ArrayList<String> students_temp = new ArrayList<String>();
    ArrayList<ArrayList<String>> students = new ArrayList<ArrayList<String>>();

    int count = 0; // Number of students
    while (scanner.hasNext() == true) {

        students_temp.add(scanner.nextLine());
        count++;

    }

    student[] student_array = new student[count];

    for (int i = 0; i < students_temp.size(); i++) {
        // Add each entry in the students_temp variable to the students list as a list of strings
        students.add(new ArrayList<String>(Arrays.asList(students_temp.get(i).split("\\s*,\\s*"))));
        // Student info
        int Studentid = Integer.parseInt(students.get(i).get(0));
        String[] name = students.get(i).get(1).split("\\s");
        String Fname = name[0];
        String Lname = name[1];
        String[][] units = new String[(students.get(i).size()-2)/3][3]; // The units the student has, as an array of arrays
        // Floats because we need real division
        float element = 2; // The element in students.get(i)
        float unit = 0; // The unit we are on eg: [300, D, 78]
        float item = 0; // The item within the unit eg: D
        boolean isFirst = true;
        while (element < students.get(i).size()) {
            if ((((element - 2)/3) % 1 == 0) && (!isFirst))
                unit++;
            if (item > 2)
                item = 0;
            units[(int)unit][(int)item] = students.get(i).get((int)element);
            item++;
            element++;
            isFirst = false;
        }
        student_array[i] = new student(Studentid, Fname, Lname, units);
    }
}