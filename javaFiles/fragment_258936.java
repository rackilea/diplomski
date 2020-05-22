public class ConsoleInteraction  {

  public static int numberOfJavaTrainees ;
  public static int numberOfPHPTrainees ;

  //Don't read that every time...
  ResourceBundle bundle = ResourceBundle.getBundle("resources/consolemessages");


  public static void main(String[] args) {
    //Moving Scanner out of loop
    try {
        Scanner scanner = new Scanner(System.in);
        ConsoleInteraction ci = new ConsoleInteraction();
        //Loop until this returns false
        while(ci.interactor(scanner)) {
            System.out.println("=== Next iteration ===");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

 }

//Constant values to make code readable
public final static int PREF_TRAINING = 1;
public final static int PREF_SHOW_CAMP = 2;
public final static int PREF_QUIT = 99;

public boolean interactor(Scanner scanner) throws IOException {

    // Prompt for training or viewing camp       
    System.out.print(bundle.getString("INITIAL_MESSAGE"));
    //Get the preference as an integer
    int preference = scanner.nextInt();

    //Show options based on preference.

    if(preference == PREF_TRAINING) {
        //LIKE YOU DID BEFORE OR calling method:
        readTraining(scanner);
    } else if (preference == PREF_SHOW_CAMP) {
        //LIKE YOU DID BEFORE OR calling mathod:
        showCamp();
    } else if (preference == PREF_QUIT) {
        //Last loop
        return false;
    }  else {
        System.out.print(bundle.getString("ERROR_MESSAGE2"));
    }   
    //Next loop
    return true;
}
}