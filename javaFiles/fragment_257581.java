String document[] = {"String1","String2","String3"};
    PrintWriter outputFile = 
        new PrintWriter(new BufferedWriter(new FileWriter(docName)));
     int lineNo = 1;

     for(int i = 0; i < document.length; i++)
     {  outputFile.println(document[i]);
        lineNo++;
     }