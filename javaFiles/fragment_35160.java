DefaultHashService hashService = new DefaultHashService();
hashService.setHashIterations(HASH_ITERATIONS); // 500000
hashService.setHashAlgorithmName(Sha256Hash.ALGORITHM_NAME);
hashService.setPrivateSalt(new SimpleByteSource(PRIVATE_SALT)); // Same salt as in shiro.ini, but NOT base64-encoded.
hashService.setGeneratePublicSalt(true);

DefaultPasswordService passwordService = new DefaultPasswordService();
passwordService.setHashService(hashService);
String encryptedPassword = passwordService.encryptPassword("PasswordForThisUser");