for (String arg : args) {
    if (arg.matches("^[A-Z]+$")) {
        System.out.println("uppercase");
    } else if (arg.matches("^[a-z]+$")) {
        System.out.println("lowercase");
    } else if (arg.matches("^[0-9]+$")) {
        System.out.println("digits");
    } else {
        System.out.println("other");
    }
}