if (f.exists()) {   
    try {
        reader = new BufferedReader(new FileReader(
              System.getProperty("user.home") + "/Desktop/Settings.txt"));
        line = reader.readLine();

    } catch (IOException e2) {
      // ... etc....