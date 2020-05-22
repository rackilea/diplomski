public static void main(String[] args) {

    String telephoneNr = "88765432";

    if (telephoneNr.matches("^(?=(?:[8-9]){1})(?=[0-9]{8}).*")) {
        System.out.println("Valid phone number!");
    }
    else {
        System.out.println("Invalid!");
    }
}