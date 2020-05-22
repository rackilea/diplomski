<?php 

$mcrypt = new MCrypt();
#Encrypt
$encrypted = $mcrypt->encrypt("Text to encrypt");
#Decrypt
$decrypted = $mcrypt->decrypt($encrypted);