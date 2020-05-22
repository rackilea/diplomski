String data = "11112222";
String secret64 = "mtHa5YRivVrQ/ZNtoe2oxg==";
byte[] secret = Base64.decode(secret64, Base64.DEFAULT);
SecretKeySpec key = new SecretKeySpec(secret, "HmacSHA1");
Mac mac = Mac.getInstance("HmacSHA1");
mac.init(key);
byte[] bytes = mac.doFinal(data.getBytes("UTF-8"));
return Base64.encodeToString(bytes, Base64.DEFAULT);