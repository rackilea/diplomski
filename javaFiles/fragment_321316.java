@Converter
public class JPACryptoConverter implements AttributeConverter<String, String>...

//To using Strong pw hash 
public static String hash(String plainPassword) {
    if (StringUtils.isBlank(plainPassword)) {
        throw new EmptyPasswordException("Password could not be empty");
    }
    return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
}

public static boolean checkPassword(String plainPassword, String hash) {
    return BCrypt.checkpw(plainPassword, hash);
}