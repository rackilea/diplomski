theVariable = scan.nextLine();

while (theVariable.startsWith("[0123456789]")) {
    System.out.println("The variable is illegal");
    theVariable = scan.nextLine();
}

while (theVariable.contains("[ ]")) {
    System.out.println("The variable is illegal");
    theVariable = scan.nextLine();
}

while (theVariable.startsWith("[!@#$%^&*]")) {
    System.out.println("The variable is legal, but has bad style");
    theVariable = scan.nextLine();
}