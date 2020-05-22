private ArrayList<Course> listCourses = new ArrayList<>();

ArrayList<Student> students = new ArrayList<>();

while(inFile.hasNextLine()){
    name = inFile.nextLine(); //first line is name
    StringTokenizer st = new StringTokenizer(inFile.nextLine()); //separting whitespace
    id = st.nextToken(); //storing ID
    coursesTaken = Integer.parseInt(st.nextToken()); //storing num_courses_taken

    Student s1 = new Student(name, id);
    ArrayList<Course> courses = new ArrayList<>();

    for(int i = 0; i < coursesTaken; i++){
        courseName = inFile.nextLine();

        StringTokenizer st2 = new StringTokenizer(inFile.nextLine());
        grade = st2.nextToken().charAt(0);
        courseUnit = Integer.parseInt(st2.nextToken());

        courses.add(new Course(courseName, grade, courseUnit)); //FIXED

    }
    s1.setListCourses(courses);
    students.add(s1); //FIXED

}