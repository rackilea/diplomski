import org.apache.commons.codec.digest.Crypt;

...

String hash = Crypt.crypt("password".getBytes());
System.out.println("salted hash: "+hash);
// salt is $X$some_bytes
String salt = hash.substring(0, hash.indexOf("$", 3));
System.out.println("salt: "+salt);
// validation:
String testString = Crypt.crypt("password", salt);
if(testString.equals(hash)) {
  System.out.println("Password match");
} else {
  System.out.println("Invalid password");
}