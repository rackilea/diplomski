public static void main(String[] args) throws MalformedURLException {
    URL url = new URL("/jsp/js/jquery-1.4.4.js");

    try {
        URLConnection connection = url.openConnection();
        InputStream stream = connection.getInputStream();

        byte[] b = new byte[100];
        for (int i = 0; i < 100;i++) {
            b[i] = (byte) stream.read();
        }

        System.out.println(new String(b));

        stream.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
}