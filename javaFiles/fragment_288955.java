Uint8List password = utf8.encode("password");
Uint8List salt = utf8.encode("helloworld");

Argon2 argon2 = Argon2(iterations: 16, hashLength: 64, memory: 256, parallelism: 2);
Uint8List hash = await argon2.argon2i(password, salt);

// send hash to the server