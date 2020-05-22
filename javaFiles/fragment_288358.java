import java.util.Base64;

//base64 encoding
byte[] encodedBytes = Base64.getEncoder().encode("Test".getBytes("UTF-8"));
System.out.println("encodedBytes " + new String(encodedBytes));
//base64 decoding
byte[] decodedBytes = Base64.getDecoder().decode(encodedBytes);
System.out.println("decodedBytes " + new String(decodedBytes));