// declare key *** here***
String key = "";


{
    FileReader file = new FileReader("C:/Users/John/Documents/key.txt");
    BufferedReader reader = new BufferedReader(file);

    // don't declare it here
    // String key = "";
    String line = reader.readLine();

    while (line != null) {
        key += line;
        line = reader.readLine();
    }
    System.out.println(key); // so key works
}

// but here, the key variable is in fact visible as it is now **within scope**
String encryptedMsg = encrypt(message, key);