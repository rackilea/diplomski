// determine the high score
    int highScore = 0;
    try {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        while (line != null)                 // read the score file line by line
        {
            try {
                int score = Integer.parseInt(line.trim());   // parse each line as an int
                if (score > highScore)                       // and keep track of the largest
                { 
                    highScore = score; 
                }
            } catch (NumberFormatException e1) {
                // ignore invalid scores
                //System.err.println("ignoring invalid score: " + line);
            }
            line = reader.readLine();
        }
        reader.close();

    } catch (IOException ex) {
        System.err.println("ERROR reading scores from file");
    }