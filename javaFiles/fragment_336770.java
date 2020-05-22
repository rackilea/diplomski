package jwt_validate_signature_sf_no_third_party;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.RSAPublicKeySpec;
import org.apache.commons.codec.binary.Base64;

public class Main
{
    // Sample id_token that needs validation. This is probably the only field you need to change to test your id_token.
    // If it doesn't work, try making sure the MODULUS and EXPONENT constants are what you're using, as detailed below.
    public static final String id_token = "YOUR_ID_TOKEN_HERE";
    public static final String[] id_token_parts = id_token.split("\\.");

    // Constants that come from the keys your token was signed with.
    // Correct values can be found from using the "kid" value and looking up the "n (MODULUS)" and "e (EXPONENT)" fields
    // at the following url: https://login.salesforce.com/id/keys
    //     MAJOR NOTE: This url will work for 90% of your use cases, but for the other 10%
    //     you'll need to make sure you get the "kid" value from the instance url that 
    //     the api responses from Salesforce suggest for your token, as the kid values *will* be different.
    //     e.g. Some users would need to get their kid values from https://na44.salesforce.com/id/keys for example.
    // The following 2 values are hard coded to work with the "kid=196" key values.
    public static final String MODULUS = "5SGw1jcqyFYEZaf39RoxAhlq-hfRSOsneVtsT2k09yEQhwB2myvf3ckVAwFyBF6y0Hr1psvu1FlPzKQ9YfcQkfge4e7eeQ7uaez9mMQ8RpyAFZprq1iFCix4XQw-jKW47LAevr9w1ttZY932gFrGJ4gkf_uqutUny82vupVUETpQ6HDmIL958SxYb_-d436zi5LMlHnTxcR5TWIQGGxip-CrD7vOA3hrssYLhNGQdwVYtwI768EvwE8h4VJDgIrovoHPH1ofDQk8-oG20eEmZeWugI1K3z33fZJS-E_2p_OiDVr0EmgFMTvPTnQ75h_9vyF1qhzikJpN9P8KcEm8oGu7KJGIn8ggUY0ftqKG2KcWTaKiirFFYQ981PhLHryH18eOIxMpoh9pRXf2y7DfNTyid99ig0GUH-lzAlbKY0EV2sIuvEsIoo6G8YT2uI72xzl7sCcp41FS7oFwbUyHp_uHGiTZgN7g-18nm2TFmQ_wGB1xCwJMFzjIXq1PwEjmg3W5NBuMLSbG-aDwjeNrcD_4vfB6yg548GztQO2MpV_BuxtrZDJQm-xhJXdm4FfrJzWdwX_JN9qfsP0YU1_mxtSU_m6EKgmwFdE3Yh1WM0-kRRSk3gmNvXpiKeVduzm8I5_Jl7kwLgBw24QUVaLZn8jC2xWRk_jcBNFFLQgOf9U";
    public static final String EXPONENT = "AQAB";

    public static final String ID_TOKEN_HEADER = base64UrlDecode(id_token_parts[0]);
    public static final String ID_TOKEN_PAYLOAD = base64UrlDecode(id_token_parts[1]);
    public static final byte[] ID_TOKEN_SIGNATURE = base64UrlDecodeToBytes(id_token_parts[2]);

    public static String base64UrlDecode(String input)
    {
        byte[] decodedBytes = base64UrlDecodeToBytes(input);
        String result = new String(decodedBytes, StandardCharsets.UTF_8);
        return result;
    }

    public static byte[] base64UrlDecodeToBytes(String input)
    {
        Base64 decoder = new Base64(-1, null, true);
        byte[] decodedBytes = decoder.decode(input);

        return decodedBytes;
    }

    public static void main(String args[])
    {
        dumpJwtInfo();
        validateToken();
    }

    public static void dump(String data)
    {
        System.out.println(data);
    }

    public static void dumpJwtInfo()
    {
        dump(ID_TOKEN_HEADER);
        dump(ID_TOKEN_PAYLOAD);
    }

    public static void validateToken()
    {
        PublicKey publicKey = getPublicKey(MODULUS, EXPONENT);
        byte[] data = (id_token_parts[0] + "." + id_token_parts[1]).getBytes(StandardCharsets.UTF_8);

        try
        {
            boolean isSignatureValid = verifyUsingPublicKey(data, ID_TOKEN_SIGNATURE, publicKey);
            System.out.println("isSignatureValid: " + isSignatureValid);
        }
        catch (GeneralSecurityException e)
        {
            e.printStackTrace();
        }

    }

    public static PublicKey getPublicKey(String MODULUS, String EXPONENT)
    {
        byte[] nb = base64UrlDecodeToBytes(MODULUS);
        byte[] eb = base64UrlDecodeToBytes(EXPONENT);
        BigInteger n = new BigInteger(1, nb);
        BigInteger e = new BigInteger(1, eb);

        RSAPublicKeySpec rsaPublicKeySpec = new RSAPublicKeySpec(n, e);
        try
        {
            PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(rsaPublicKeySpec);

            return publicKey;
        }
        catch (Exception ex)
        {
            throw new RuntimeException("Cant create public key", ex);
        }
    }

    private static boolean verifyUsingPublicKey(byte[] data, byte[] signature, PublicKey pubKey) throws GeneralSecurityException
    {
        Signature sig = Signature.getInstance("SHA256withRSA");
        sig.initVerify(pubKey);
        sig.update(data);

        return sig.verify(signature);
    }
}