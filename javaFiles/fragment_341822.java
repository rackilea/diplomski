import 'package:pointycastle/export.dart';

class Example {
  Uint8List encrypt(String data) {
    if (data == null || data.length == 0) return null;
    final Uint8List _key = utf8.encode('key');
    final Uint8List _iv = utf8.encode('iv');
    try {
      Uint8List encrypted;
      final CipherParameters params = PaddedBlockCipherParameters(
        ParametersWithIV(
          KeyParameter(_key),
          _iv,
        ),
        null,
      );
      final PaddedBlockCipherImpl cipher = PaddedBlockCipherImpl(
        PKCS7Padding(),
        CBCBlockCipher(
          AESFastEngine(),
        ),
      );
      cipher.init(true, params);
      encrypted = cipher.process(utf8.encode(data));
      return encrypted;
    } catch (_) {
      print(_);
      return null;
    }
  }

  String decrypt(Uint8List data) {
    if (data == null || data.length == 0) return null;
    final Uint8List _key = utf8.encode('key');
    final Uint8List _iv = utf8.encode('iv');
    try {
      final CipherParameters params = PaddedBlockCipherParameters(
        ParametersWithIV(
          KeyParameter(_key),
          _iv,
        ),
        null,
      );
      final PaddedBlockCipherImpl cipher = PaddedBlockCipherImpl(
        PKCS7Padding(),
        CBCBlockCipher(
          AESFastEngine(),
        ),
      );
      cipher.init(false, params);
      final String finalData = utf8.decode(cipher.process(data));
      return finalData;
    } catch (_) {
      print(_);
      return null;
    }
  }
}