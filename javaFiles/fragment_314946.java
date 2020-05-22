<?php
     class CbcCrypt {

           private $iterations = 16;
           private $key_lenght = 16;
           private $password = "password";
           //parametro utilizzato da key per generare la chiave
           private $salt = array(0xA7, 0x71, 0x1F, 0xF5, 0x5D, 0xD2, 0x28, 0x8F);
           //parametro utilizzato dall'algoritmo per il cript
           private $iv = array(0xCB, 0x35, 0xF3, 0x52, 0x1A, 0xF7, 0x38, 0x0B, 0x75, 0x03, 0x8E, 0xE0, 0xEF, 0x39, 0x98, 0xC7);

           public function encrypt($data) {
               $ivStr = implode(array_map("chr", $this->iv));
               $saltStr = implode(array_map("chr", $this->salt));
               //key generator
               //$hash = hash_pbkdf2("sha1", $this->password, $saltStr, $this->iterations, $this->key_lenght, true);
               $hash = $this->pbkdf2($this->password, $saltStr, "sha1", $this->iterations, $this->key_lenght, true);
               $td = mcrypt_module_open('rijndael-128', '', 'cbc', $ivStr);
               //aggiunta del padding
               $toEncryptStrPadded = $this->pkcs5_pad($data);
               mcrypt_generic_init($td, $hash, $ivStr);
               $encrypted = mcrypt_generic($td, $toEncryptStrPadded);
               //print_r('base64 enc: ' . base64_encode($encrypted));
               mcrypt_generic_deinit($td);
               mcrypt_module_close($td);
               return base64_encode($encrypted);
           }

           function pbkdf2($password, $salt, $algorithm = 'sha512', $count = 20000, $key_length = 128, $raw_output = false) {
               if (!in_array($algorithm, hash_algos(), true)) {
                   exit;
               }
           if ($count <= 0 || $key_length <= 0) {
               $count = 20000;
               $key_length = 128;
           }

           $hash_length = strlen(hash($algorithm, "", true));
           $block_count = ceil($key_length / $hash_length);

           $output = "";
           for ($i = 1; $i <= $block_count; $i++) {
               $last = $salt . pack("N", $i);
               $last = $xorsum = hash_hmac($algorithm, $last, $password, true);
               for ($j = 1; $j < $count; $j++) {
                   $xorsum ^= ($last = hash_hmac($algorithm, $last, $password, true));
               }
               $output .= $xorsum;
           }

           if ($raw_output) {
               return substr($output, 0, $key_length);
           } else {
               return base64_encode(substr($output, 0, $key_length));
           }
       }

       function pkcs5_pad($text) {
           $blocksize = 16;
           $pad = $blocksize - (strlen($text) % $blocksize);

?>