public class AlphaNumericCounter {
    String[] part;

    int counter; //Variable storing numeric part of counter

    String alpha; //Variable storing Alpha part of counter

    static String final_output = "A00"; // First Input considered as A00 and also the variable which will be store each count

    static boolean continueIncrement = true; //For running the loop till we reach ZZ9

    /* Def constructor */    
    public AlphaNumericCounter() {
    }

    /* Constructor called from main method with primary input A00 */
    public AlphaNumericCounter(String number) {
        part = number.split("(?<=\\D)(?=\\d)");
    }

    /* Function called each time from inside loop to generate next alphanumeric count */
    public void increment() {
        part = final_output.split("(?<=\\D)(?=\\d)");
        counter = Integer.valueOf(part[1]) + 1;
        alpha = part[0];
    }

    public String toString() {
        if (alpha.length() == 1){
            if (String.valueOf(counter).length() > 2){
                if ((int)alpha.charAt(0) + 1 > 90/*If Z encountered*/){
                    alpha = "AA";
                }else{
                    alpha = String.valueOf((char)((int)alpha.charAt(0) + 1));//Take Next Alphabet
                }
                counter = 1; //Reset counter to 1
            }
        }else{
            //We have AA, AB ... ZZ format of alpha
            if (String.valueOf(counter).length() > 1){
                if ((int)alpha.charAt(0) + 1 > 90 && (int)alpha.charAt(1) + 1 > 90){
                    continueIncrement = false;
                    System.out.println("NO MORE COMBINATION AVAILABLE"); //We reached ZZ
                    return "";
                }else if ((int)alpha.charAt(1) + 1 <= 90){
                    alpha = String.valueOf((char)((int)alpha.charAt(0))) + String.valueOf((char)((int)alpha.charAt(1) + 1));
                    counter = 1;
                }else if ((int)alpha.charAt(1) + 1 > 90){
                    if ((int)alpha.charAt(0) + 1 <= 90){
                        alpha = String.valueOf((char)((int)alpha.charAt(0) + 1)) + "A";
                        counter = 1;
                    }
                }
            }
        }

        generateString();

        return final_output;

    }

    private void generateString(){
        int l1 = String.valueOf(counter).length();
        int l2 = alpha.length();

        final_output = alpha + (l2 == 1 && l1 == 1 ? "0" : "") + String.valueOf(counter);
    }

    public static void main(String[] args) {
        AlphaNumericCounter lic = new AlphaNumericCounter(final_output);

        while (continueIncrement){
            lic.increment();
            System.out.println(lic);
        }
    }
}