public interface JwtTokenManager extends TokenManager {
    String aMethodNotDefinedInInterface();
}

public class TokenManagerFactory {

    public static <T extends TokenManager> T create(Class<T> managerInterface) {
        if (managerInterface == JwtTokenManager.class) {
            return (T) new JwtTokenManagerImpl();
        }

        return null;
    }
}