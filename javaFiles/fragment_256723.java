try {
    int s = 1 / 0;
} catch (Exception e) {
    try {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sd = new SimpleDateFormat("yyyy_MM_dd");
        String s = sdf.format(d);
        String day = sd.format(d);

        FileOutputStream fos = new FileOutputStream("src/log/" + day + "_Exception.log");
        PrintStream ps = new PrintStream(fos);

        ps.println(s);

        System.setErr(ps);
    } catch (Exception e2) {
    }
    e.printStackTrace(System.err);
}