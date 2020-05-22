import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.interfaces.ECPrivateKey;
import java.util.Date;


    KeyStore store = KeyStore.getInstance("PKCS12");
    //
    store.load(new FileInputStream("/home/andrew/keystore.p12"), "test".toCharArray());
    ECPrivateKey pk = (ECPrivateKey) store.getKey("selfsigned", "test".toCharArray());

    Algorithm algorithmHS = Algorithm.ECDSA256(null, pk);
    String token = JWT.create()
        .withSubject("")
        .withExpiresAt(new Date())
        .withNotBefore(new Date())
        .withIssuer("issuer")
        .withClaim("roles", "b")
        .withClaim("keys", "b")
        .sign(algorithmHS);