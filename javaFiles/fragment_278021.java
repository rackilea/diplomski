public class UserVerifier extends SecretVerifier {
    private SecurityDao securityDao;
    public void setSecurityDao(SecurityDao securityDao) {
        this.securityDao = securityDao;
    }

    public boolean verify(String identifier, char[] secret) {
        System.out.println(identifier);
        System.out.println(secret);
        return securityDao.hasUserPassword(identifier, new String(secret));
        return true;
    }
}