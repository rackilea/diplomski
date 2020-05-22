$secret64 = "mtHa5YRivVrQ/ZNtoe2oxg==";
$secret = base64_decode($secret64);
$data = "11112222";
$hmac  = hash_hmac('sha1', $data, $secret, true);
$hmac64 = base64_encode($signature);
echo $hmac64;