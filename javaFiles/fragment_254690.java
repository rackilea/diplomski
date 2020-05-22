String base64 = "AAAAE2VjZHNhLXNoYTItbmlzdHAyNTYAAAAIbmlzdHAyNTYAAABBBG93uDMAjwxpPFXgLFFs7FzWZXrQRaXnBMqmHaRN/5JRzljuqYAUAkW98HvFxGKrnb2JdW3X785AxLNzVhiiw+4=";
byte[] bytes = Base64.getDecoder().decode(base64), temp;

if( clean ){
    DataInputStream instr = new DataInputStream (new ByteArrayInputStream (bytes));
    temp = new byte[instr.readInt()]; instr.read(temp);
    if( !Arrays.equals(temp,"ecdsa-sha2-nistp256".getBytes())) throw new Exception ("bad key");
    temp = new byte[instr.readInt()]; instr.read(temp);
    if( !Arrays.equals(temp,"nistp256".getBytes())) throw new Exception ("bad key");
    temp = new byte[instr.readInt()]; instr.read (temp);
}else{
    temp = Arrays.copyOfRange(bytes, bytes.length-65, bytes.length);
}
ECNamedCurveParameterSpec ecSpec = ECNamedCurveTable.getParameterSpec ("secp256r1");
org.bouncycastle.math.ec.ECPoint point = ecSpec.getCurve().decodePoint (temp);
KeyFactory keyFactory = KeyFactory.getInstance("ECDSA", "BC");
PublicKey pk = keyFactory.generatePublic(new org.bouncycastle.jce.spec.ECPublicKeySpec(point, ecSpec));