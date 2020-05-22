BigInteger result = new BigInteger(inputs[0], 2);

for (int i = 1; i < inputs.length; i++) {
    result = result.and(new BigInteger(inputs[i], 2));
}

String resultStr = result.toString(2);