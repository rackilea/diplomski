Field handshakerField = sslSocket.getClass().getDeclaredField(
            "handshaker");
    handshakerField.setAccessible(true);
    Object handShakerObj = handshakerField.get(sslSocket);
    System.out.println(handShakerObj);

    // Only start the handshake *after* you've got hold of the handshaker object,
    // otherwise it will be null.
    sslSocket.startHandshake();

    Class<?> handshakerClass = Class.forName("sun.security.ssl.Handshaker");
    Field clientRandomField = handshakerClass
            .getDeclaredField("clnt_random");
    clientRandomField.setAccessible(true);
    Object clientRandomObj = clientRandomField.get(handShakerObj);
    System.out.println(clientRandomObj);

    Field randomBytesField = clientRandomObj.getClass().getDeclaredField(
            "random_bytes");
    randomBytesField.setAccessible(true);
    byte[] randomBytesObj = (byte[])randomBytesField.get(clientRandomObj);