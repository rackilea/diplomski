try {
    String line;
    Process p = Runtime.getRuntime().exec("ps -e");
    BufferedReader input =
            new BufferedReader(new InputStreamReader(p.getInputStream()));
    while ((line = input.readLine()) != null) {
        System.out.println(line); //<-- Parse data here.
    }
    input.close();
} catch (Exception err) {
    err.printStackTrace();
}