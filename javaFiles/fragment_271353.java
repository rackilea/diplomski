import java.security.KeyFactory;
import java.security.Security;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;

import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.ECPointUtil;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.util.encoders.Base64;


// you need to add the BouncyCastle provider to use its functionalities
Security.addProvider(new BouncyCastleProvider());

String publicK = "BBoN_OkTfE_0uObues82qHr96z8x3nepYoUwCBoftFDS_Vgx2MUHN1vAFxc1eDiyDrvmZ2bQ4sJq3F8Qz71RWI0=";
// publicK is encoded in base64, so you need to decode it first
byte[] publicBytes = Base64.decode(publicK.getBytes());

// spec for P-256 curve
ECNamedCurveParameterSpec spec = ECNamedCurveTable.getParameterSpec("prime256v1");
// create a KeyFactory with ECDSA (Elliptic Curve Diffie-Hellman) algorithm and use BouncyCastle as the provider
KeyFactory kf = KeyFactory.getInstance("ECDSA", BouncyCastleProvider.PROVIDER_NAME);

// code below just creates the public key from the bytes contained in publicK
// using the curve parameters (spec variable)
ECNamedCurveSpec params = new ECNamedCurveSpec("prime256v1", spec.getCurve(), spec.getG(), spec.getN());
ECPoint point = ECPointUtil.decodePoint(params.getCurve(), publicBytes);
ECPublicKeySpec pubKeySpec = new ECPublicKeySpec(point, params);
ECPublicKey pk = (ECPublicKey) kf.generatePublic(pubKeySpec);

System.out.println(pk.toString());