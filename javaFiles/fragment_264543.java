try {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = input.readLine()) != null) {
            System.out.println("Hello, " + line + "! How are you today?");
        }   
    } catch (IOException ioex) {
        ioex.printStackTrace();
    }