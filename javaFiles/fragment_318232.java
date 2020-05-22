Base obscure = new Base("^JsdloYF9%");
Base base64 = new Base("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
BigInteger value = new BigInteger("123456789012345678901234567890"); // Too large for int and long
String obscureValue = obscure.toString(value);
String base64Value = base64.toString(value);

System.out.println(obscureValue);
System.out.println(base64Value);
System.out.println(base64.convertTo(obscure, base64Value));
System.out.println(obscure.convertTo(base64, obscureValue));