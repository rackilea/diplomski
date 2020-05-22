SecureRandom seeder = new SecureRandom();
byte[] seed = seeder.generateSeed(NOS_BYTES);

SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");
prng.setSeed(seed);

SecureRandom prng2 = SecureRandom.getInstance("SHA1PRNG");
prng2.setSeed(seed);

// prng1 and prng2 created as above should generate the same sequences