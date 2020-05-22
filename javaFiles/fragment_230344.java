class Scratch {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("----------------------------------");
        System.out.println("    Program Gabung Kata");
        System.out.println("    Dibuat oleh 1402019129");
        System.out.println("----------------------------------");

        System.out.print("Enter First word: "); // Enter First word
        String firstString = sc.nextLine();                // Bbxx
        System.out.print("Enter Second word  : "); // Enter Second word
        String secondString = sc.nextLine();               // oxxx

        String combinedString = ""; // new String that is a combination from first and
        // second
        String[] targetNames = {"Bob", "Zidan", "Fawzan", "Arkan", "Raihan"};
        boolean shouldContinue = true;
        int index = 0;

        String interlacedString = createInterlacedString(firstString, secondString);
        do {
            for (String targetName: targetNames) {

                if (combinedString.equals(targetName)) {
                    shouldContinue = false;
                    break;
                }
            }

            if(shouldContinue){
                combinedString += interlacedString.charAt(index);
                index++;
            }
        } while(shouldContinue
                && (index < firstString.length())
                && (index < secondString.length())
        );

        System.out.println("New Word: " + combinedString);
        System.out.println("Is the new word is one of the names? " + !shouldContinue);

    }

    public static String createInterlacedString(String stringOne, String stringTwo){
        String interlacedString = "";
        for(int i = 0; i < stringOne.length(); i++){
            interlacedString += stringOne.charAt(i);
            if(i < stringTwo.length()){
                interlacedString += stringTwo.charAt(i);
            }
        }
        if(stringTwo.length() > stringOne.length()){
            interlacedString += stringTwo.substring(stringOne.length());
        }
        return interlacedString;
    }
}