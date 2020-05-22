public class Hospital {

    public String firstName;
    public String lastName;
    public static int patientID = 1;
    public int phoneNum;
    private static int i = 0;
    private static Hospital[] hosArray = new Hospital[100];

    public Hospital() {
        firstName = "";
        lastName = "";
        patientID = 0;
        phoneNum = 0;
    }

    public Hospital(String fName, String lName, int pID, int pNum) {
        firstName = fName;
        lastName = lName;
        patientID = patientID++;
        phoneNum = pNum;
    }

    public static void scanner() {
        Scanner user = new Scanner(System.in);
        System.out.print("Enter 1 to add patient: ");
        int input = user.nextInt();

        if (input == 1) {
            System.out.print("Enter first name: ");
            String fName = user.next();

            System.out.print("Enter last name: ");
            String lName = user.next();

            System.out.print("Enter phone number: ");
            int pNum = user.nextInt();
            if (hosArray[i] == null) {
                hosArray[i] = new Hospital();
                hosArray[i] = new Hospital(fName, lName, Hospital.patientID,
                        pNum);
                i++;
            }
            scanner();
        }
    }

    public int getpID() {
        return patientID;
    }

    public static void main(String[] args) {
        scanner();

        for (int j = 0; j < hosArray.length; j++) {
            if (hosArray[j] != null) {
                System.out.println(hosArray[j].firstName);
            }
        }
    }
}