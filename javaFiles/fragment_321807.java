Security.addProvider(new BouncyCastleProvider());

String plainString = "Plaintext Secret";

// instantiate the BouncyCastle digest directly.
MessageDigest messageDigest = new SHA512Digest();
byte[] hashedString = messageDigest.digest(plainString.getBytes());

doSomething().with(hashedString);