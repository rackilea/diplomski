//provided key 
byte[] keyBinary = DatatypeConverter.parseBase64Binary("r/RloSflFkLj3Pq2gFmdBQ==");     // decode base64-encoded key in a byte-array
SecretKey secret = new SecretKeySpec(keyBinary, "AES");                                 // create AES-key from byte-array (currently 16 Byte = 128 Bit long) 

// encrypted string    
byte[] bytes = DatatypeConverter.parseBase64Binary("IKWpOq9rhTAz/K1ZR0znPA==");         // decode base64-encoded encrypted data in a byte-array

// iv
byte[] iv = DatatypeConverter.parseBase64Binary("yzXzUhr3OAt1A47g7zmYxw==");            // decode base64-encoded IV in a byte-array     
Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");                             // create cipher-instance for using AES in CBC-mode with PKCS5-Padding (Java counterpart to PKCS7)
cipher.init(Cipher.DECRYPT_MODE, secret, new IvParameterSpec(iv));                      // initialize cipher-instance for decryption with specified AES-key and IV (the latter created from corresponding byte-array) 
String msisdn = new String(cipher.doFinal(bytes), "UTF-8");                             // decrypt data using AES-128 (128 determined by length of used key in Bit), CBC-mode and PKCS5-Padding, 
                                                                                        // and put them in a UTF-8 string
System.out.println(msisdn); // Output: 1234567                                          // print decrypted data