private static String[] createPassword(String password) {
    String [] saltPassword = new String[2];
    try{
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[32];
        random.nextBytes(salt);

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt);
        md.update(password.getBytes("UTF8"));
        byte[] digest = md.digest();

        saltPassword[0] = DatatypeConverter.printHexBinary(salt);
        saltPassword[1] = DatatypeConverter.printHexBinary(digest);

        System.out.println(DatatypeConverter.printHexBinary(digest));


    }catch(NoSuchAlgorithmException e1){
        System.out.println("FATAL ERROR: " + e1);
        System.exit(0);
    }catch(UnsupportedEncodingException e2){
        System.out.println("FATAL ERROR: " + e2);
        System.exit(0);
    }

    return(saltPassword);
}