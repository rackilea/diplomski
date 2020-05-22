<?php
$date = "201603251605";
$name = "some_dummy_data_one";
$size = "some_dummy_data_two";

$md5_name = md5($name, true);

$token_bytes = $size.$date.$md5_name;

$token_hash = hash("sha256", $token_bytes, true);

echo base64_encode($token_hash);