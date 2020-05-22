String line;
    int currentLineNo = 1;
    int startLine = 20056;//40930;
    int endLine = 1159450;

    FileReader file = new FileReader("yourfilepath");
    BufferedReader reader = new BufferedReader(file);

    PrintWriter writer = new PrintWriter("yourfilepath", "UTF-8");

    while(currentLineNo<=endLine) 
    {
        line = reader.readLine();
        if(currentLineNo >= startLine && currentLineNo<=endLine) 
        {  System.out.println(line); }

        currentLineNo++;
    }

    reader.close();
    writer.close();