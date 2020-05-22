Socket s = new Socket("localhost", 8888);
BufferedReader in = null;

try {
    in = new BufferedReader(new InputStreamReader(s.getInputStream()));

    String line;
    while ((line = in.readLine()) != null) {
        System.out.println(line);
    }
}
finally {
    if (in != null) {
        in.close();
    }
    s.close();
}