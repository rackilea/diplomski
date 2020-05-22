public static String formatAlignToRight(String x){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);
        System.out.printf("%20s",x); //This is right aligning for 20 characters
        System.out.flush();
        System.setOut(old);
        return baos.toString();
    }