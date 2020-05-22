function oaes_decrypt($ciphertext, $privatekey) {
    $rsa = new \Crypt_RSA();
    $rsa->setEncryptionMode(CRYPT_RSA_ENCRYPTION_OAEP);
    $rsa->setMGFHash('sha1');
    $rsa->setHash('sha256');
    $rsa->loadKey($privatekey);

    return $rsa->decrypt($ciphertext);
}