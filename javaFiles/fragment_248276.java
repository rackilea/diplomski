InputStream is = System.in;
    BufferedReader in = new BufferedReader(new InputStreamReader(is));

    System.out.println("Enter Book Title: ");
    String input = "";

    try {
        input = in.readLine();
        System.out.println("Your Input: " + input);

        is.close();
        in.close();
    } catch (IOException e) {
        System.out.println("Error reading input");
    }