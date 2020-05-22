while (true) {
    scanner = new Scanner(System.in);
    System.out.println("enter something: ");

    line = scanner.nextLine(); // scanner checks and returns the input that was skipped
    if (line.equalsIgnoreCase("Exit")) {
        break;
    } else {
        scanner = new Scanner(line);

        while (scanner.hasNext()) { // check for other words in line
        input = scanner.next(); // finds and returns next complete token form this scanner          

        firstLetter = input.charAt(0);

        /*first if*/ if ('A' <= firstLetter && firstLetter <= 'Z') { // checking first letter
            firstLetter = Character.toLowerCase(firstLetter);
            capital = true;
        } else {
            capital = false;
        }

        /*second if*/ if (vowels != null) {  // checking if first letter is a vowelFGriopt;khtyl      mhp
            output = (input + "ay");
        } else {
            if (capital) { // setting first letter to upperCase 
                output = "" + Character.toUpperCase(input.charAt(1));  // char to String conversion
                output = output + input.substring(2) + firstLetter + "ay";
            } else {
                output = input.substring(1) + firstLetter + "ay";
            }
        }
        if (line.isEmpty()) {
            output.isEmpty();
        }

        System.out.print(output + " ");
    }
}