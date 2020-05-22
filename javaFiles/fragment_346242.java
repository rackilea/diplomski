import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class JwtVerification {

    private static final String SECRET = "zZrq0sZK1yt9RJk51RTJ/jeU6WERbvr8nqKMWQJRX1E=";

    public static DecodedJWT verify(String token) throws JWTVerificationException, UnsupportedEncodingException {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(Base64.getDecoder().decode(SECRET)))
                .withIssuer("auth0")
                .acceptLeeway(1)
                .acceptExpiresAt(5 * 60)
                .build();

        return verifier.verify(token);
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        final String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0aWQiOiJiZWJlMjM4Zi1iMGM4LTQwYzMtOTYyMC1jZDRlOGUyMzIwZGMiLCJvaWQiOiI5MjJjMmZiNC0zNWI1LTExZDctOWE2NC0wMGIwZDBmY2I5ZTMiLCJzdWIiOiI5MjJjMmZiNC0zNWI1LTExZDctOWE2NC0wMGIwZDBmY2I5ZTMiLCJlbWFpbCI6InRlc3RAdGVzdC5jb20iLCJpYXQiOjE1MTg0NDk5NzYsImV4cCI6MTUxODQ1MzU3NiwibmJmIjoxNTE4NDQ5OTc2fQ.6InknrU67g_HEkaLxD9Ul5vOzbYGf54mJNcSyPr-xek";
        System.out.println(verify(token));
    }
}