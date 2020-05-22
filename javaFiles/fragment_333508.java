public static void main(String[] args) throws Exception {
    Process proc = Runtime.getRuntime().exec("cat");

    byte[] buffer = new byte[100_000];
    OutputStream out = proc.getOutputStream();
    out.write(buffer);
    out.close();

    InputStream in = proc.getInputStream();
    int count = in.read(buffer);
    System.out.println(count);
}