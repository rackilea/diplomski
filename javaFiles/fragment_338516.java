byte[] privKey = new byte[32];
privKey[31] = 2;

ECNamedCurveParameterSpec spec = ECNamedCurveTable.getParameterSpec("secp256k1");
ECPoint pointQ = spec.getG().multiply(new BigInteger(1, privKey));

pointQ = pointQ.normalize();

System.out.println(pointQ.getRawXCoord());
System.out.println(pointQ.getRawYCoord());