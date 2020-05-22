public int getChar() {
    sc = new Scanner(inputFile);
...
    // solving your problem with the last '\n'
    while (sc.hasNextLine()) {
        String line = sc.nextLine();
        if (sc.hasNextLine())
            Char += line.length() + 1;
        else
            Char += line.length();
    }
    return char;
}