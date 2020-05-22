public InputStream decrypt(InputStream inputStream) {

    assert supportedStreamModes.contains(mode) : "Unsupported cipher mode for stream decryption " + mode;

    @SuppressWarnings("squid:S2095") final ExceptionAwarePipedInputStream pis = new ExceptionAwarePipedInputStream();
    final ExceptionAwarePipedOutputStream pos = newConnectedPipedOutputStream(pis);
    final Cipher decryptor = newDecryptorInitialized(inputStream);

    CompletableFuture.runAsync(
        pipeDecryptorRunnable(inputStream, pos, decryptor));

    return pis;
}

private ExceptionAwarePipedOutputStream newConnectedPipedOutputStream(ExceptionAwarePipedInputStream pis) {
    try {
        return new ExceptionAwarePipedOutputStream(pis);
    } catch (IOException e) {
        throw new CryptographyException(e.getMessage(), e);
    }
}