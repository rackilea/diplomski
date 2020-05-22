public static void main(String[] args) {
    try {
        URL url = new URL("http://www.google.com");

        InputStream is = url.openStream();

        ByteArrayOutputStream os = new ByteArrayOutputStream();

        byte[] buffer = new byte[1024]; 

        int count;
        while ((count = is.read(buffer)) != -1) {
            os.write(buffer, 0, count);
        }

        is.close();

        String json = new String(os.toByteArray());

        System.out.println(json);
    } catch (MalformedURLException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}