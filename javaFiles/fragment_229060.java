byte[] bytes = new byte[57];
String enc1 = new sun.misc.BASE64Encoder().encode(bytes);
String enc2 = new String(java.util.Base64.getMimeEncoder().encode(bytes),
                         StandardCharsets.UTF_8);

System.out.println("enc1 = <" + enc1 + ">");
System.out.println("enc2 = <" + enc2 + ">");
System.out.println(enc1.equals(enc2));