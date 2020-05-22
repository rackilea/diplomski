<?php

echo base64_encode($_GET['str'])." Default UTF-8 version<br />";
echo base64_encode(iconv("UTF-8","CP1252",$_GET['str']))." CP1252 Version <br />";

?>

usage: http://[SOMEDOMAIN]/test.php?str=†+Ü]M(‡=ñö