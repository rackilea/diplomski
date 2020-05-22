public class MainClas {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);

        String mapString = map.entrySet().toString();
        System.out.println(mapString);

        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        byte[] hashBytes = digest.digest(mapString.getBytes());

        String hashString =  bytesToHex(hashBytes);

        System.out.println(hashString);
    }

    private static String bytesToHex(byte[] hashInBytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) sb.append(String.format("%02x", b));
        return sb.toString();
    }
}