$buffer = file_get_contents("image.png");
 $length = filesize("image.png");

 if (!$buffer || !$length) {
   die("Reading error\n");
 }

 $_buffer = '';
 for ($i = 0; $i < $length; $i++) {
   $_buffer .= sprintf("%08b", ord($buffer[$i]));
 }

 echo $_buffer."<br>";

 $nb = "";
 for($i = 0;$i<strlen($_buffer)/8;$i++) {
     $sub = substr($_buffer, $i*8,8);
     $nb .= chr(bindec($sub));
 }
 $new = fopen("aaaimage.png","wb");
 $w = fwrite($new,$nb);