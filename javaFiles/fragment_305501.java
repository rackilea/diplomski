//format public key in CRYPT format
    $publicKey = "-----BEGIN RSA PUBLIC KEY-----\r\n" . chunk_split($pumpumString) . 
    "-----END RSA PUBLIC KEY-----";

    //initialise Algorithm
    $rsa = new Crypt_RSA();
    $rsa->loadKey($publicKey); // public key
    $rsa->setEncryptionMode(CRYPT_RSA_ENCRYPTION_PKCS1);

    //generate new AES Session Key
    $AESKey = rand_sha1(32); //a custom created function

    $AESKeyDecoded = base64_decode($AESKey);

    //encrypt AES Session Key
    $ciphertext = $rsa->encrypt($AESKeyDecoded);

    //base 64 encode it for transfer over internet
    $ciphertextEncoded = base64_encode($ciphertext);

    //prepare array for sending to client
    $response = array('plum' => $ciphertextEncoded);

    //write the encoded and decoded AES Session Key to file for comparison
    $file = fopen('key.txt', 'w');
    fwrite($file, "\n". $AESKey);

    //echo JSON
    echo json_encode($response);