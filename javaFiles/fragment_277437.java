public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String version = System.getProperty("java.version");
        System.out.print(version + " || " + decodeMeee());
    }

    private static String decodeMeee() throws UnsupportedEncodingException {
        byte[] content = Base64.getDecoder()
                .decode("jZsq4NNN0K4HzssoDEakhImknSVHLWpsmIF2AEBNacLykXJWBK9VKmCuuX1SR5iMNlfqXe7/eP8oLFEZp50E3g==");
        return new String(content, 0, content.length, "UTF-8"); // <-- replace with correct encoding format
    }
}