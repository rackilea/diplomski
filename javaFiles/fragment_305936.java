public class ID {
static List<Oseba> id = new ArrayList<Oseba>();
\*we create the menu like that in order to avoid multiple lines repetitions *\
private static String menuOptions = "Menu:" + "\nExit - Insert 0"
            + "\nAdd contact - Insert 1" + "\nExit Outprint all contacts - Insert 2";

public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int max = 0;
    int choice = 0;
    boolean isDate = false;

    System.out.println("How many IDs would you like to enter? ");
    max = sc.nextInt();
    Person p = new Person();

    while (true) {
        print(menuOptions);
        choice = sc.nextInt();
        switch (choice) {
        case 0:
            System.out.println("Goodbye!");
            System.exit(0);

        case 1:
                while(true){
                    String fname = getString("Enter First Name: ");
                    if(verifyName(fname)){
                        p.setFirstName(fname);
                        break;
                    }
                }
                while(true){
                    String lname = getString("Enter Last Name: ");
                    if(verifyName(lname)){
                        p.setLastName(lname);
                        break;
                    }
                }
                while(true){
                    String date = getString("Enter date of birth (dd-mm-yyyy): ");
                    if(verifyBirthDate(date)){
                        p.setDate(date);
                        break;
                    }
                }
                while(true){
                    String birthPlace = getString("Enter place of birth: ");
                    if(verifyBirthPlace(birthPlace)){
                        p.setPlace(birthPlace);
                        break;
                    }
                }
                while(true){
                    String email = getString("Enter email address: ");
                    if(verifyEmail(email)){
                        p.setEmail(email);
                        break;
                    }
                }
                while(true){
                    String phoneNumber = getString("Enter phone number: ");
                    if(verifyPhoneNumber(phoneNumber)){
                        p.setPhone(phoneNumber);
                        break;
                    }
                }
                addID(p);
            break;

        case 2:
            System.out.println("\n" + ID.id);
            break;

        default:
            System.out.println("Try again.");
            break;
        }
        print(menuOptions);
        choice = sc.nextInt();
    }
}

    private static void addID(Person prs) {
      id.add(prs);
    }

   public static Boolean verifyName(String name) {
        if(!name.matches("[a-zA-Z]+")){
            print("\nERROR_MESSAGE:____________The first/last name should contain only letters, everything else is not valid!");
            return false;
        }else{
            return true;
        }
    }

    public static Boolean verifyBirthDate(String date) {
        String regEx_Date = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";
        if(!date.matches(regEx_Date)){
            print("\nERROR_MESSAGE:____________The birth date is not valid!");
            return false;
        }else{
            return true;
        }
    }

    public static Boolean verifyBirthPlace(String birthPlace) {
        if(!birthPlace.matches("[a-zA-Z]+")){
            print("\nERROR_MESSAGE:____________The birth place is not valid!");
            return false;
        }else{
            return true;
        }
    }


    public static Boolean verifyEmail(String email) {
        String regEx_Email = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern p = Pattern.compile(regEx_Email);
        Matcher m = p.matcher(email);
        if(!m.find()){
            print("\nERROR_MESSAGE:____________"+email+" is an invalid email address");
            return false;
        }else{
            return true;
        }
    }

    public static Boolean verifyPhoneNumber(String phoneNumber) {
        if(!phoneNumber.matches("[0-9]+")){
            print("\nERROR_MESSAGE:____________The phone No. should contain only numbers, everything else is not valid!");
            return false;
        }else{
            return true;
        }
    }

    public static String getString(String msg) {
        Scanner in = new Scanner(System.in);
        print(msg);
        String s = in.nextLine();
        return s;
    }

    public static void print(String s) {
        System.out.println(s);
    }


}