try {
        // Open the file that is the first
        // command line parameter
        FileInputStream fstream = new FileInputStream("Simple.java");
        // Get the object of DataInputStream
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        //Read File Line By Line
        char c;
        while ((c = (char) br.read()) != (char) -1) {
            // Print the content on the console
            String character = Character.toString(c);
            System.out.print(character);
        }
        //Close the input stream
        in.close();
    } catch (Exception e) {//Catch exception if any
        System.err.println("Error: " + e.getMessage());
    }