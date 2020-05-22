byte[] base64String = Base64.decode(encodedString);
byte[] plainBytes = new String(base64String).getBytes("UTF-8");
byte[] cipherData = cipher.doFinal(plainBytes);

System.out.println(cipherData);
return cipherData.toString();