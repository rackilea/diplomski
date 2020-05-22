BufferedReader in = null;
try {
    in = new BufferedReader(new InputStreamReader(System.in));
    String line;
    while ((line = in.readLine()) != null) {  //print lines (or do whatever you need)
        System.out.println(line);
    }
} catch (IOException e) {
    e.printStackTrace();
}