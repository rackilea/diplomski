public class Part1_5 {
    public static void main(String[] args) {

        // Setting up scanner
        Scanner scanner = new Scanner(System.in);

        // declaring string for name
        String userName = null;

        // declaring ints to hold total no of each vowel
        int totalOfA = 0,totalOfE = 0,totalofI = 0,totalofO = 0,totalofU = 0;

        // Get user input for name
        System.out.println("Please enter your Name...");
        userName = scanner.nextLine();

        // declaring char array (declare it once, before the loop)
        char[] letter = userName.toCharArray();

        for (int loop = 0; loop < userName.length(); loop++) {

            // check and count for any vowel at every iteration of the loop
            if (userName.charAt(loop) == 'a')
                totalOfA++;
            else if (userName.charAt(loop) == 'e')
                totalOfE++;
            else if (userName.charAt(loop) == 'i')
                totalOfI++;
            else if (userName.charAt(loop) == 'o')
                totalOfO++;
            else if (userName.charAt(loop) == 'u')
                totalOfU++;
        }
        System.out.println(totalOfA);
    }
}