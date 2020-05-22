boolean storedExitLauncher;
    boolean storedDevConsole;
    try {
        File dataContiner = new File("data.dat");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(dataContiner));
        storedExitLauncher = Boolean.parseBoolean(bufferedReader.readLine());
        storedDevConsole = Boolean.parseBoolean(bufferedReader.readLine());

    } catch (FileNotFoundException e) {
        storedDevConsole = storedExitLauncher = false;
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

    //do your stuff here
    boolean exitLauncher = false; //save the checkbox data
    boolean devConsole = false; //save checkbox data

    try {
        PrintWriter printWriter = new PrintWriter("data.dat", "UTF-8");
        printWriter.println(exitLauncher);
        printWriter.println(devConsole);
    } catch (FileNotFoundException e) {
        throw new RuntimeException("Cannot save data, it will be lost");
    } catch (UnsupportedEncodingException e) {
        throw new RuntimeException(e);
    }