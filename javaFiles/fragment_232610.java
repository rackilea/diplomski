import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Project5_test2 {
    public static Object Student;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        // initialize an arary that holds N objects of type Student
        int end = 1;
        ArrayList<Student> studentList = new ArrayList<Student>();

        // read in the data
        for (int y = 0; y < end;) {
            String nextMove = nextMove();
            for (int i = 0; i < end;) {
                if ("add".equalsIgnoreCase(nextMove)) {
                    System.out.println("Student Input: ");
                    String firstName = getFirstName();
                    String lastName = getLastName();
                    int uid = getUid();
                    String stringUid = Integer.toString(uid);
                    StudentType type = inputStudentType();
                    ClassStanding standing = inputClassStanding();
                    Student base = new Student(firstName, lastName, uid, type, standing);
                    if (type == StudentType.UNDECLARED) {
                        studentList.add(base);
                    }
                    else if (type == StudentType.UNDERGRADUATE) {
                        Major major = inputMajor();
                        double overallGpa = getOverallGPA();
                        String overallGpaDouble = Double.toString(overallGpa);
                        double majorGpa = getOverallGPA();
                        String majorGpaDouble = Double.toString(majorGpa);
                        studentList.add(base);
                    }
                    else if (type == StudentType.GRADUATE) {
                        boolean thesis = getThesisStatus();
                        //String thesisString = Boolean.toString(thesis);
                        ClassStanding studyType = getStudy();
                        String profName = getProfName();
                        studentList.add(new Student.Graduate(base, thesis, studyType, profName));
                    }
                } i++;
            }

            if ("remove".equalsIgnoreCase(nextMove)) {
                System.out.println("derp");
            }

            if ("save".equalsIgnoreCase(nextMove)) {
                for (int i = 0; i < studentList.size(); i++) {
                    System.out.println(studentList.get(i));
                }
                y++;
            }
        }
    }

    enum ClassStanding {

        FRESHMAN, SOPHOMORE, JUNIOR, SENIOR, UNKNOWN,
        MASTERS_STUDIES, PHD_STUDIES, NO_STANDING
    };

    enum StudentType {

        UNDERGRADUATE, GRADUATE, UNDECLARED
    };

    enum Major {

        CS, CEG, EE, ISE, BME, ME, MET, UNKNOWN
    };

    public static class Student {

        public String firstName;     // first name
        public String lastName;
        public double uid;      // last name
        public StudentType type;
        public ClassStanding standing;

        public Student(Student orig) {
            this.firstName = orig.firstName;
            this.lastName = orig.lastName;
            this.uid = orig.uid;
            this.type = orig.type;
            this.standing = orig.standing;
        }

        // construct a new student with given fields
        public Student(String firstName, String lastName, Integer newUid, StudentType type, ClassStanding standing) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.uid = newUid;
            this.type = type;
            this.standing = standing;
        }


        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getLastName() {
            return lastName;
        }
        //set type

        public void setType(StudentType type) {
            this.type = type;
        }
        //return type

        public StudentType getType() {
            return type;
        }

        public void setStanding(ClassStanding standing) {
            this.standing = standing;
        }
        //return type

        public ClassStanding getStanding() {
            return standing;
        }

        // return a string representation of the invoking object
        public String toString() {
            return firstName + " " + lastName + " " + uid + " " + type + " " + standing;
        }

        public static class Graduate extends Student {

            public boolean thesis;
            public ClassStanding study;
            public String profName;

            public Graduate(Student orig, boolean isThesis, ClassStanding study, String profName) {
                super(orig);
                thesis = isThesis;
                this.study = study;
                this.profName = profName;
            }

            public boolean getThesis() {
                return thesis;
            }

            public void setThesis(Boolean thesis) {
                this.thesis = thesis;
            }

            public ClassStanding getStudy() {
                return study;
            }

            public void setStudy(ClassStanding study) {
                this.study = study;
            }

            public String getProfName() {
                return profName;
            }

            public void setProfName(String profName) {
                this.profName = profName;
            }

            public String toString() {
                return super.toString() + thesis + " " + study + " " + profName;
            }
        }

        public static class UnderGraduate extends Student {

            public Major major;
            public Double GPA;

            public UnderGraduate(Student orig, Major major, Double GPA) {
                super(orig);
            }

            public void setMajor(Major major) {
                this.major = major;
            }
            //return type

            public Major getmMajor() {
                return major;
            }

            public void setOverallGPA(Integer uid) {
                this.uid = uid;
            }

            public double getOverallGPA() {
                return uid;
            }

            public String toString() {
                return major + " " + uid ;
            }
        }
    }

    public static String getFirstName() {
        Scanner input = new Scanner(System.in);
        String firstName;
        while (true) {
            //prompt the user to enter the popularity number for each character
            try {
                System.out.print("Please enter the students first name: ");
                firstName = input.next();
                break;
                //error handling
            } catch (InputMismatchException e) {
                System.out.println("Not a string please enter another first name!");
                input.next();
                continue;
            }
        }
        return firstName;
    }

    public static String getLastName() {
        Scanner input = new Scanner(System.in);
        String lastName;
        while (true) {
            //prompt the user to enter the popularity number for each character
            try {
                System.out.print("Please enter a students last name: ");
                lastName = input.next();
                break;
                //error handling
            } catch (InputMismatchException e) {
                System.out.println("Not a string please enter another last name!");
                input.next();
                continue;
            }
        }
        return lastName;
    }

    public static Integer getUid() {
        Scanner input = new Scanner(System.in);
        int uid;
        while (true) {
            //prompt the user to enter the popularity number for each character
            try {
                System.out.print("Please enter a uid number: ");
                uid = input.nextInt();
                break;
                //error handling
            } catch (InputMismatchException e) {
                System.out.println("Not a number or an integer!");
                input.next();
                continue;
            }
        }
        return uid;
    }

    public static StudentType inputStudentType() {
        Scanner input = new Scanner(System.in);
        String type;
        while (true) {
            //prompt the user to enter the popularity number for each character
            try {
                System.out.print("Is the student a graduate, undergraduate, or, undeclared: ");
                type = input.next();

                break;
                //error handling
            } catch (InputMismatchException e) {
                System.out.println("False input. Is the student a graduate, undergraduate, or, undeclared: ");
                type = input.next();
                continue;
            }
        }
        if ("undergraduate".equalsIgnoreCase(type)) {
            StudentType status = StudentType.UNDERGRADUATE;
            return status;
        }
        if ("graduate".equalsIgnoreCase(type)) {
            StudentType status = StudentType.GRADUATE;
            return status;
        }
        if ("undeclared".equalsIgnoreCase(type)) {
            StudentType status = StudentType.UNDECLARED;
            return status;
        }
        return null;

    }

    public static String nextMove() {
        Scanner input = new Scanner(System.in);
        String nextMove;
        while (true) {
            // prompt the user to enter if there are more characers
            try {
                System.out.print("What now? Add, Sort, Remove, Save: ");
                nextMove = input.next();
                break;
                //error handling
            } catch (InputMismatchException e) {
                System.out.println("More input? true or false(type true or false): ");
                input.next();
                continue;
            }
        }
        return nextMove;
    }

    public static ClassStanding inputClassStanding() {
        Scanner input = new Scanner(System.in);
        String type;
        while (true) {
            //prompt the user to enter the popularity number for each character
            try {
                System.out.print("Enter the students class standing:  ");
                type = input.next();
                break;
                //error handling
            } catch (InputMismatchException e) {
                System.out.println("False input. Input the students class standing: ");
                type = input.next();
                continue;
            }
        }
        if ("Freshman".equalsIgnoreCase(type)) {
            ClassStanding standing = ClassStanding.FRESHMAN;

            return standing;
        }
        if ("sophomore".equalsIgnoreCase(type)) {
            ClassStanding standing = ClassStanding.SOPHOMORE;

            return standing;
        }
        if ("junior".equalsIgnoreCase(type)) {
            ClassStanding standing = ClassStanding.JUNIOR;

            return standing;
        }
        if ("senior".equalsIgnoreCase(type)) {
            ClassStanding standing = ClassStanding.SENIOR;
            return standing;
        }
        if ("unknown".equalsIgnoreCase(type)) {
            ClassStanding standing = ClassStanding.UNKNOWN;
            return standing;
        }
        return null;

    }

    public static Major inputMajor() {
        Scanner input = new Scanner(System.in);
        String major;
        while (true) {
            //prompt the user to enter the popularity number for each character
            try {
                System.out.print("Enter the students major (CS, CEG, EE, ISE, BME, ME, MET, UNKNOWN):  ");
                major = input.next();
                break;
                //error handling
            } catch (InputMismatchException e) {
                System.out.println("False input. Enter the students major (CS, CEG, EE, ISE, BME, ME, MET, UNKNOWN): ");
                major = input.next();
                continue;
            }
        }
        if ("cs".equalsIgnoreCase(major)) {
            Major finalMajor = Major.CS;
            return finalMajor;
        }
        if ("ceg".equalsIgnoreCase(major)) {
            Major finalMajor = Major.CEG;
            return finalMajor;
        }
        if ("ee".equalsIgnoreCase(major)) {
            Major finalMajor = Major.EE;
            return finalMajor;
        }
        if ("ise".equalsIgnoreCase(major)) {
            Major finalMajor = Major.ISE;
            return finalMajor;
        }
        if ("bme".equalsIgnoreCase(major)) {
            Major finalMajor = Major.BME;
            return finalMajor;
        }
        if ("ME".equalsIgnoreCase(major)) {
            Major finalMajor = Major.ME;
            return finalMajor;
        }
        if ("met".equalsIgnoreCase(major)) {
            Major finalMajor = Major.MET;
            return finalMajor;
        }
        if ("unknown".equalsIgnoreCase(major)) {
            Major finalMajor = Major.UNKNOWN;
            return finalMajor;
        }
        return null;

    }

    public static Double getOverallGPA() {
        Scanner input = new Scanner(System.in);
        double overallGpa;
        while (true) {
            //prompt the user to enter the popularity number for each character
            try {
                System.out.print("Please enter the students overall GPA: ");
                overallGpa = input.nextDouble();
                break;
                //error handling
            } catch (InputMismatchException e) {
                System.out.println("Not a number or an integer! Please enter the students overall GPA:");
                input.next();
                continue;
            }
        }
        return overallGpa;
    }

    public static Double getMajorlGPA() {
        Scanner input = new Scanner(System.in);
        double majorGpa;
        while (true) {
            //prompt the user to enter the popularity number for each character
            try {
                System.out.print("Please enter the students major GPA: ");
                majorGpa = input.nextDouble();
                break;
                //error handling
            } catch (InputMismatchException e) {
                System.out.println("Not a number or an integer! Please enter the students major GPA:");
                input.next();
                continue;
            }
        }
        return majorGpa;
    }

    public static boolean getThesisStatus() {
        Boolean thesis;
        Scanner input = new Scanner(System.in);
        while (true) {
            //prompt the user to enter the popularity number for each character
            try {
                System.out.print("Enter TRUE for having a thesis option else FALSE: ");
                thesis = input.nextBoolean();
                break;
                //error handling
            } catch (InputMismatchException e) {
                System.out.println("Not a boolean response. True or false, is there a thesis: ");
                input.next();
                continue;
            }
        }
        return thesis;
    }

    public static ClassStanding getStudy() {
        String study = null;
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 1;) {
            while (true) {
                //prompt the user to enter the popularity number for each character
                try {
                    System.out.print("Enter Masters for Master Studies or Phd for Phd studies: ");
                    study = input.next();
                    break;
                    //error handling
                } catch (InputMismatchException e) {
                    System.out.println("Not a valid response. Enter Masters for Master Studies or Phd for Phd studies: ");
                    input.next();
                    continue;
                }
            }
            if ("masters".equalsIgnoreCase(study)) {
                ClassStanding standing = ClassStanding.MASTERS_STUDIES;
                return standing;
            }
            if ("phd".equalsIgnoreCase(study)) {
                ClassStanding standing = ClassStanding.PHD_STUDIES;
                return standing;
            }
        }
        return null;
    }

    public static String getProfName() {
        String name;
        Scanner input = new Scanner(System.in);
        while (true) {
            //prompt the user to enter the popularity number for each character
            try {
                System.out.print("Enter the name of the major professor: ");
                name = input.next();
                break;
                //error handling
            } catch (InputMismatchException e) {
                System.out.println("Not a valid response. Enter the name of the major professor: ");
                input.next();
                continue;
            }
        }
        return name;
    }
}