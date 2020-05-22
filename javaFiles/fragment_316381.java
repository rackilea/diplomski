require 'openssl';

key = "97128424897797a166913557a6f4cc8e";
iv = "84e8c3ea8859a0e293941d1cb00a39c3";
encrypted_string = "395f6c0e8ad27f57c4a5a8975aa633e5b26f288d37ce18c6971779951f3b3527";

de_cipher = OpenSSL::Cipher::Cipher.new("AES-128-CBC");
de_cipher.decrypt;
de_cipher.key = [key].pack('H*');
de_cipher.iv = [iv].pack('H*');

puts de_cipher.update([encrypted_string].pack('H*')) << de_cipher.final;