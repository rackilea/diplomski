<?php
$keyBinary = base64_decode('r/RloSflFkLj3Pq2gFmdBQ==');                                 // decode base64-encoded key in a string (internally, PHP strings are byte arrays)
$bytes = base64_decode('IKWpOq9rhTAz/K1ZR0znPA==');                                     // decode base64-encoded encrypted data in a string
$iv = base64_decode('yzXzUhr3OAt1A47g7zmYxw==');                                        // decode base64-encoded IV in a string   
$msisdn = openssl_decrypt($bytes, 'AES-128-CBC', $keyBinary, OPENSSL_RAW_DATA, $iv);    // decrypt data using AES-128, CBC-mode and PKCS7-Padding (default-padding)
                                                                                        // - when OPENSSL_RAW_DATA is specified raw data are returned, otherwise base64-encoded data (= default)
                                                                                        // - when OPENSSL_ZERO_PADDING is specified no padding is used, otherwise PKCS7-padding (= default)
                                                                                        // - The value XXX in AES-XXX-CBC is determined by the length of the key in Bit used in the Java-code,
                                                                                        //   e.g. for a 32 Byte (256 Bit)-key AES-256-CBC has to be used.  
print $msisdn."\n"; // Output: 1234567                                                  // print decrypted data