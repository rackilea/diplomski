private int lineCount; {
    try{
        lineCount = LineCounter.countLines(sFileName);
        /*^^^^^^^*/
    }
    catch(IOException ex){
        System.out.println (ex.toString());
        System.out.println("Could not find file " + sFileName);
    }
}