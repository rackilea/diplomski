while (scanner.hasNext()) {
    String pair = scanner.next();
    // Split by the hyphen
    String tokens[] = pair.split("-");

    // Normally, one should check the array before accessing it
    // I currently assume the input is valid
    int first = Integer.parseInt(tokens[0]);
    int second = Integer.parseInt(tokens[1]);

    // Do whatever you want with the 2 numbers extracted
}