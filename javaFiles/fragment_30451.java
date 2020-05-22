public boolean isValidJWTToken(String jwtToken){
        boolean isValid = true;
        try {
            Jwts.parser().setSigningKey(generateKey()).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            isValid = false;
        }
        return isValid;
    }
private Key generateKey() {

        byte[] keyBytes=environment.getProperty("auth.jwt.secret.key").getBytes();

        return new SecretKeySpec(keyBytes, 0,keyBytes.length,environment.getProperty("auth.jwt.secret.algo"));
    }