private boolean validateSignature( String header, String data, String signature, String secretKey ) throws Exception {

    SecretKeySpec secret = new SecretKeySpec( secretKey.getBytes(), "HmacSHA256" );
    Mac mac = Mac.getInstance( "HmacSHA256" );
    mac.init( secret );

    String body = header + "." + data;
    byte[] hmacDataBytes = mac.doFinal( body.getBytes( StandardCharsets.UTF_8.name()) );
    String hmacData = Base64.getUrlEncoder().encodeToString( hmacDataBytes );

    return hmacData.equals( signature ); // Compare signatures here...
}