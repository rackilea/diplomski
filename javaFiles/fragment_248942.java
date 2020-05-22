public static void main(String args[]) throws IOException {

        byte[] b = {-53, 54, -5, -89, -69, -126, -57, 36, 49, 114, -66, 67, 39, 18, 57, -40, 50, -113, 52, -113, 111, -65, -20, -127, -84, 90, -74, -47, 94, 23, 18, -36};
         String encoded = Base64.getEncoder().encodeToString(b);
         System.out.println(encoded);

    }