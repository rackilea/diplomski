} catch (ClientTransportException e) {
    if (e.getCause() instanceof UnknownHostException) {
        // UHE.
    } else {
        // Other.
    }
}