<?php
$keyBinary = base64_decode('r/RloSflFkLj3Pq2gFmdBQ==');                                 
$msisdn = '1234567';                                                                    // plain text
$iv = openssl_random_pseudo_bytes(16);                                                  // generate random IV
//$iv = base64_decode('yzXzUhr3OAt1A47g7zmYxw==');                                      // use this line for tests with your base64-encoded test-IV yzXzUhr3OAt1A47g7zmYxw==   
$bytes = openssl_encrypt($msisdn, 'AES-128-CBC', $keyBinary, OPENSSL_RAW_DATA, $iv);    // encrypt data using AES-128, CBC-mode and PKCS7-Padding (default-padding) 
$ivBase64 = base64_encode($iv);                                                         // base64-encode IV
$bytesBase64 = base64_encode($bytes);                                                   // base64-encode encrypted data
print $ivBase64."\n".$bytesBase64."\n";                                                 // print base64-encoded IV and encrypted data