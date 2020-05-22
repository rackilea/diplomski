private Runnable pipeDecryptorRunnable(InputStream inputStream, ExceptionAwarePipedOutputStream pos, Cipher decryptor) {
    return () -> {
        try {

            // do stuff... and write to pos

        } catch (Exception e) {
            // Signaling any (checked or unchecked) exception
            pos.signalException(new CryptographyException(e.getMessage(), e));
        } finally {
            closePipedStream(pos);
        }
    };
}