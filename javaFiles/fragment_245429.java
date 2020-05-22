import 'dart:math';
import 'dart:convert';
import 'dart:typed_data';

import 'package:convert/convert.dart';
import 'package:pointycastle/api.dart';
import 'package:pointycastle/asymmetric/api.dart';
import 'package:pointycastle/asymmetric/rsa.dart';

String encrypt(String plaintext, String publicKey) {
  var modulusBytes = base64.decode(publicKey);
  var modulus = BigInt.parse(hex.encode(modulusBytes), radix: 16);
  var exponent = BigInt.parse(hex.encode(base64.decode('AQAB')), radix: 16);
  var engine = RSAEngine()
    ..init(
      true,
      PublicKeyParameter<RSAPublicKey>(RSAPublicKey(modulus, exponent)),
    );

  //PKCS1.5 padding
  var k = modulusBytes.length;
  var plainBytes = utf8.encode(plaintext);
  var paddingLength = k - 3 - plainBytes.length;
  var eb = Uint8List(paddingLength + 3 + plainBytes.length);
  var r = Random.secure();
  eb.setRange(paddingLength + 3, eb.length, plainBytes);
  eb[0] = 0;
  eb[1] = 2;
  eb[paddingLength + 2] = 0;
  for (int i = 2; i < paddingLength + 2; i++) {
    eb[i] = r.nextInt(254) + 1;
  }

  print(plainBytes.length);
  print(eb);

  return base64.encode(
    engine.process(eb),
  );
}