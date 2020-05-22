class Logger {
    private static boolean FIRST_CALL = true;

    public static void loggerMain(String content) {    
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("debug.txt", !FIRST_CALL)));

            if(FIRST_CALL){
                FIRST_CALL = false;
            }
            out.println(content);
            out.close();
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }
}