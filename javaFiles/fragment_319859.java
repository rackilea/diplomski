try {
    String[] parms = {"cscript", "calc.vbs", "2017-02-06 09:38:36", "2017-02-06 12:47:41"};
    Process p = Runtime.getRuntime().exec(parms);

    // Get Input Stream from the Process
    BufferedReader is = new BufferedReader(new InputStreamReader(p.getInputStream()));

    // Do something with stream, read etc.
    String line;
    while ((line = is.readLine()) != null)
        System.out.println(line);

} catch (Exception ex) {
    ex.printStackTrace();
}