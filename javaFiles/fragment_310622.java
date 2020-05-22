public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        String name = userInput.nextLine();

        int arrayLength = name.length();

        String ArrayName[] = new String [arrayLength];
        char[] chars = name.toCharArray();

        for(int counter = 0; counter < arrayLength; counter++) {
            ArrayName[counter] = chars[counter] + "";
            System.out.println("Element No" + counter + ": " + name.substring(counter));
        }
    }