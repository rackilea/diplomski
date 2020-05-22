try 
    {
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("outfilename", true)));
    out.println("the text");
    out.close();
     } catch (IOException e) {
    }