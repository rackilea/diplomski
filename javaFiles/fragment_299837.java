Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");

        String filename = "crashlogs/"+sdf.format(cal.getTime())+".txt";

        PrintStream writer;
        try {
            writer = new PrintStream(filename, "UTF-8");
            writer.println(e.getClass() + ": " + e.getMessage());
            for (int i = 0; i < e.getStackTrace().length; i++) {
                writer.println(e.getStackTrace()[i].toString());
            }

        } catch (FileNotFoundException | UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }
});