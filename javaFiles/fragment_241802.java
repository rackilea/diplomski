String lastLine = "";

    while ((sCurrentLine = br.readLine()) != null) 
    {
        System.out.println(sCurrentLine);
        lastLine = sCurrentLine;
    }