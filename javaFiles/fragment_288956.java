// Create instance
Argon2Advanced argon2 = Argon2Factory.createAdvanced();

// Read password from user
char[] password = readPasswordFromUser();

// Hash password
String hash = argon2.hash(iterations, memory, parallelism,
                          password, charset, salt)