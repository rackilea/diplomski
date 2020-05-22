private static Scanner userInput = new Scanner(System.in);

public static void main(String[] args) {

    String response = "";

    for (int inputNr = 0; inputNr <= 2; inputNr++) {
        response = getResponse();
        System.out.println(response);
    }

    userInput.close();
}

public static String getResponse() {

    String response = "";

    System.out.println("Enter a String");

    if (userInput.hasNextLine()) {
        response = userInput.nextLine();
    }

    return response;
}