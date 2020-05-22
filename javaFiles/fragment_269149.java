public static void main(String[] args) throws Exception {

    Scanner aScanner = new Scanner(
                           new FileReader("src//chapt11//ch11AS8data.txt"));

    System.out.println("Welcome to the Student Scores Application.\n");

    int nStudent = 100;
    Student[] studentArray = new Student[nStudent];
    Scanner lineScanner = null;

    int counter = 0;
    while (aScanner.hasNext()) {
        lineScanner = new Scanner(aScanner.nextLine());
        String lastName = lineScanner.next();
        String firstName = lineScanner.next();
        int examScore = lineScanner.nextInt();
        System.out.println("Student " + counter + " " + firstName + " "
                + lastName + " " + +examScore);

        studentArray[counter++]=new Student(lastName, firstName, examScore);
        lineScanner.close();
    }

    for(int j = 0; j < counter; j++){  
        System.out.println(studentArray[j]);
    }



    //sort based on first name
    Arrays.sort(studentArray,0,counter, new Comparator<Student>(){
        @Override
        public int compare(Student s1, Student s2) {
            return s1.getFirstName().compareTo(s2.getFirstName());
        }
    });
    System.out.println("Students sorted by first name in ascending order");
    for(int j = 0; j < counter; j++){  
        System.out.println(studentArray[j]);
    }

    //sort based on score
    Arrays.sort(studentArray,0,counter, new Comparator<Student>(){
        @Override
        public int compare(Student s1, Student s2) {
            return Integer.valueOf(s1.getExamScore()).
                               compareTo(Integer.valueOf(s2.getExamScore()));
        }
    });
    System.out.println("Students sorted by score in ascending order");
    for(int j = 0; j < counter; j++){  
        System.out.println(studentArray[j]);
    }

    //To compute the average:
    double sum = 0.0;
    for(int j = 0; j < counter; j++){  
        sum+=studentArray[j].getExamScore();
    }
    double average = (sum*1.0)/counter;
    System.out.println("Average Score = "+average );


    aScanner.close();
}