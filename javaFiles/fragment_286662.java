// here is some block of code:
{
    FileReader file = new FileReader("C:/Users/John/Documents/key.txt");
    BufferedReader reader = new BufferedReader(file);

    // **** key is declared here in this block of code
    String key = "";
    String line = reader.readLine();

    while (line != null) {
        key += line;
        line = reader.readLine();
    }
    System.out.println(key); // so key works
}

// but here, the key variable is not visible as it is **out of scope**
String encryptedMsg = encrypt(message, key);