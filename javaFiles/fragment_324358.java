<?php
$bytes = $_GET["bytes"]; 
$temp = intval ($bytes);
$result = str_pad("",$temp,"*");
header('Content-Length: ' . $temp);
echo($result);
?>