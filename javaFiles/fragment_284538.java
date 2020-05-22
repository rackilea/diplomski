try {
    outputTextLen += cipher.doFinal(outputText, outputTextLen);
} catch (CryptoException err) {
    err.printStackTrace();
}

if(eod) {
    return new String(Base64.encode(outputText));
} else {
    return new String(outputText, 0, outputTextLen);
}