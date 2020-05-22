Scanner console = new Scanner(System.in);
String input = "";

for (;!"X".equals(input);) { // notice, the first and last part of the for loop are absent

    displayMenu();

    input = console.nextLine().toUpperCase();
    System.out.println();

    switch (input) {
        case "A": System.out.println("Option #A was selected"); break;
        case "B": System.out.println("Option #B was selected"); break;
        case "C": System.out.println("Option #C was selected"); break;
        case "D": System.out.println("Option #D was selected"); break;
        case "X": System.out.println("You chose to Exit"); break;
        default: System.out.println("Invalid selection made"); break;
    }
}