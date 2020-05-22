import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.utils.Numeric;

...

String privateKey = <YOUR_PRIVATE_KEY>;
String publicKey = <YOUR_PUBLIC_KEY>;

ECKeyPair keyPair = new ECKeyPair(Numeric.toBigInt(privateKey), Numeric.toBigInt(publicKey));

Credentials credentials = Credentials.create(keyPair);