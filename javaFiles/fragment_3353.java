$data = "xWnsqJJ4pqWTrm8kIwfyw1djD4lu0zig0wnohS+EtwDvHBgEP/BS25qyaE+QEdxd";
$keystring = "MyPassphraseXYZ";
$salt = "A99BC8325634E303";
$iterationsMd5 = 19; 
$decrypted = PbeWithMd5AndDes::decrypt($data, $keystring, $salt, $iterationsMd5);
print($decrypted . "\n");