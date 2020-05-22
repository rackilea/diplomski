function extract_key($pkcs1) {
    # strip out -----BEGIN/END RSA PUBLIC KEY-----, line endings, etc
    $temp = preg_replace('#.*?^-+[^-]+-+#ms', '', $pkcs1, 1);
        $temp = preg_replace('#-+[^-]+-+#', '', $temp);
        return str_replace(array("\r", "\n", ' '), '', $temp);
}

$rsa = new Crypt_RSA();
$keysize=2048;
 $pubformat = "CRYPT_RSA_PUBLIC_FORMAT_PKCS1";
 $privformat = "CRYPT_RSA_PRIVATE_FORMAT_PKCS8";
$rsa->setPrivateKeyFormat(CRYPT_RSA_PRIVATE_FORMAT_PKCS8);
$rsa->setPublicKeyFormat(CRYPT_RSA_PUBLIC_FORMAT_PKCS1);
$d = $rsa->createKey($keysize);
 $Kp = $d['publickey'];
 $Ks = $d['privatekey'];


$rsa = new Crypt_RSA();
$rsa->setPrivateKeyFormat(CRYPT_RSA_PRIVATE_FORMAT_PKCS8);
$rsa->setPublicKeyFormat(CRYPT_RSA_PUBLIC_FORMAT_PKCS1);
$d = $rsa->createKey($keysize);
$Kver = $d['publickey'];
$KSign = $d['privatekey'];

file_put_contents("pub_verify_key.txt",extract_key($Kver));

$plainText = "53965C38-E950-231A-8417-074BD95744A4:22-434-565-54544:".extract_key($Kp);

file_put_contents("plain.txt",$plainText);

// Signing
$hash = new Crypt_Hash('sha256');
$rsa = new Crypt_RSA();    
$rsa->loadKey($KSign);
$rsa->setSignatureMode(CRYPT_RSA_ENCRYPTION_PKCS1);
$rsa->setHash('sha256');

$signature = $rsa->sign($plainText);

$signedHS = base64_encode($signature);

file_put_contents("signedkey.txt", $signedHS);

// Verification

$signature = base64_decode($signedHS);
$rsa->loadKey($Kver);
$status = $rsa->verify($plainText, $signature);

var_dump($status);