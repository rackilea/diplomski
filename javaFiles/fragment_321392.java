<?php
$key = base64_decode('KioqKioqKioqKioqKioqKg==');
$input = base64_decode($_GET['input']);
$plain_text = substr($input, 16);
$initialization_vector = substr($input, 0, 16);
echo pkcs5_unpad(mcrypt_decrypt(MCRYPT_RIJNDAEL_128, $key, $plain_text, MCRYPT_MODE_CBC, $initialization_vector));

function pkcs5_unpad($text) {
    $pad = ord($text{strlen($text)-1});
    if ($pad > strlen($text)) {
        return false;
    }
    if (strspn($text, chr($pad), strlen($text) - $pad) != $pad) {
        return false;
    }
    return substr($text, 0, -1 * $pad);
}
?>