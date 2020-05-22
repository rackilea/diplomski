<?php

function hex2bin($hexdata) {
   $bindata = '';

   for ($i = 0; $i < strlen($hexdata); $i += 2) {
    $bindata .= chr(hexdec(substr($hexdata, $i, 2)));
   }

   return $bindata;
} 

$key = "password";
$data = "This is a sample text message";

$key = str_pad($key,16);

$blockSize = mcrypt_get_block_size(MCRYPT_RIJNDAEL_128, MCRYPT_MODE_CBC);
$padding   = $blockSize - (strlen($data) % $blockSize);
$data      .= str_repeat(chr($padding), $padding);

$c = mcrypt_encrypt(MCRYPT_RIJNDAEL_128, $key, $data, MCRYPT_MODE_CBC, 'fedcba9876543210');

$c = bin2hex($c);

echo $c;


echo PHP_EOL;


$c = hex2bin($c);
$td = mcrypt_module_open(MCRYPT_RIJNDAEL_128,'',MCRYPT_MODE_CBC, '');
mcrypt_generic_init($td, $key, 'fedcba9876543210');
$decrypted = mdecrypt_generic($td, $c);
mcrypt_generic_deinit($td);
mcrypt_module_close($td);

echo $decrypted;