SecretKeySpec signingKey = new SecretKeySpec(key, "HmacSHA1");
Mac mac = Mac.getInstance("HmacSHA1");
mac.init(signingKey);
// The big problem is difference between C# and Java encoding
byte[] rawHmac = mac.doFinal(data.getBytes("UTF-16LE"));
result = new String(Base64.encode(rawHmac));