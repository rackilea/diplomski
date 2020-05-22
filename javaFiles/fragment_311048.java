function encryptText($plainText, $key) {
    $keyData = "\xA2\x15\x37\x08\xCA\x62\xC1\xD2"
        . "\xF7\xF1\x93\xDF\xD2\x15\x4F\x79\x06"
        . "\x67\x7A\x82\x94\x16\x32\x95";

    $padded = pkcs5_pad($plainText,
        mcrypt_get_block_size("tripledes", "cbc"));

    $encText = mcrypt_encrypt("tripledes", $keyData, $padded, "cbc", $key);

    return base64_encode($encText);
}

function decryptText($encryptText, $key) {
    $keyData = "\xA2\x15\x37\x08\xCA\x62\xC1\xD2"
        . "\xF7\xF1\x93\xDF\xD2\x15\x4F\x79\x06"
        . "\x67\x7A\x82\x94\x16\x32\x95";

    $cipherText = base64_decode($encryptText);

    $res = mcrypt_decrypt("tripledes", $keyData, $cipherText, "cbc", $key);

    $resUnpadded = pkcs5_unpad($res);

    return $resUnpadded;
}


function pkcs5_pad ($text, $blocksize)
{
    $pad = $blocksize - (strlen($text) % $blocksize);
    return $text . str_repeat(chr($pad), $pad);
}

function pkcs5_unpad($text)
{
    $pad = ord($text{strlen($text)-1});
    if ($pad > strlen($text)) return false;
    if (strspn($text, chr($pad), strlen($text) - $pad) != $pad) return false;
    return substr($text, 0, -1 * $pad);
}