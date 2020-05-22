// Hash a new password for storing in the database.
// The function automatically generates a cryptographically safe salt.
String hashToStoreInDb = BCrypt.hashpw(password, BCrypt.gensalt());

// Check if the hash of the entered login password, matches the stored hash.
// The salt and the cost factor will be extracted from existingHashFromDb.
Boolean isPasswordCorrect = BCrypt.checkpw(password, existingHashFromDb);