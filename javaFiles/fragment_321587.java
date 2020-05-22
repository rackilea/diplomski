String text = "I+am+good+boy";
    System.out.println("Using Tokenizer : ");
    StringTokenizer tokenizer = new StringTokenizer(text, "+");
    while (tokenizer.hasMoreTokens()) {
        String token = tokenizer.nextToken();
        System.out.println(" Token = " + token);
    }

    System.out.println("\n Using Split :");
    String [] array = text.split("\\+");
    for (int i = 0; i < array.length; i++) {
        System.out.println(array[i]);
    }