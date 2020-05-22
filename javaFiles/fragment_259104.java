String cipherText;
boolean secondLine = false;
String inFile = new File(firstArg).getAbsolutePath();
Path file = new File(inFile).toPath();

try {
    InputStream in = Files.newInputStream(file);
    BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {

    String line = null;

    while ((line = reader.readLine()) != null) {


        if (!secondLine) //first line reading
        {
            cipherText = line; 
            secondLine = true;
        }
        else if (secondLine) //second line reading
        {   
            cipherKeyPairs.put(cipherText, line);
            secondLine = false;
        }
    }
} catch (IOException x) {
    System.err.println(x);
}