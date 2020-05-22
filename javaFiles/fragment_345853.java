unsigned char salt[8];
memset(salt, 1, 8);

unsigned char key[32];
gcry_kdf_derive("password", 8, GCRY_KDF_PBKDF2, GCRY_MD_SHA256, salt, 8, 2048, 32, key);

for (int i = 0; i < 32; ++i)
    printf("%02x", key[i]);
printf("\n");