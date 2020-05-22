MessageDigest digest = MessageDigest.getInstance("SHA1");
digest.update(password.getBytes());
digest.update(salt.getBytes());
String hash = DigestUtils.sha1Hex(digest.digest());
// or
byte[] hash = DigestUtils.sha1(digest.digest());