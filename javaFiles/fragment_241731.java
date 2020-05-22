public static String getName(String input) {
    String[] names = input.split("\\s+");
    String output = "";

    // replace 1st through second to last names with capitalized 1st letter
    for (int i=names.length; i > 1; --i) {
        output += names[names.length - i].substring(0, 1).toUpperCase() + ". ";
    }

    // append full last name, first letter capitalized, rest lower case
    output += names[names.length - 1].substring(0, 1).toUpperCase()
           + names[names.length - 1].substring(1).toLowerCase();

    return output;
}

public static void main(String[] args) {
    System.out.println(getName("gandhi"));
    System.out.println(getName("mahatma gandhi"));
    System.out.println(getName("Mohndas Karamchand ganDhi"));
}