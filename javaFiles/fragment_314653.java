<?php
function pad($data, $size) {
    $length = $size - strlen($data) % $size;
    return $data . str_repeat(chr($length), $length);
}
function unpad($data) {
    return substr($data, 0, -ord($data[strlen($data) - 1]));
}
$data = 'This is a plain text which needs to be encrypted...';
$key = "SiadajerSiadajer";
$iv_size = 16; 
$iv = openssl_random_pseudo_bytes($iv_size, $strong);
$encryptedData = openssl_encrypt(pad($data, 16), 'AES-256-CBC', $key, OPENSSL_RAW_DATA, $iv);
$joinedData = $iv.$encryptedData;
$encodedJoinedData = base64_encode($joinedData);
print $encodedJoinedData."\n";