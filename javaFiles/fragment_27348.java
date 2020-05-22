// use AES itself to encrypt password to get cipher key (using plain password as source for  
// key expansion) - gives us well encrypted key
$nBytes = $nBits/8;  // no bytes in key
$pwBytes = array();
for ($i=0; $i<$nBytes; $i++) $pwBytes[$i] = ord(substr($password,$i,1)) & 0xff;
$key = Cipher($pwBytes, KeyExpansion($pwBytes));
$key = array_merge($key, array_slice($key, 0, $nBytes-16));  // expand key to 16/24/32 bytes long