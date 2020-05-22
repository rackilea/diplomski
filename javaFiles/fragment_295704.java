// format: algorithm:iterations:hashSize:salt:hash
String parts = "sha1:" +
    PBKDF2_ITERATIONS +
    ":" + hashSize +
    ":" +
    toBase64(salt) +
    ":" +
    toBase64(hash);
return parts;