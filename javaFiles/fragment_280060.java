public static void checkAdapterNameOrSetDefaultValue(Optional<Device> device) {
    if (device.isPresent()) {
        final Optional<Socket> optionalSocket = device.get().getSocket();
        if (optionalSocket.isPresent()) {
            final Socket socket = optionalSocket.get();
            if (socket.getAdapter().isEmpty()) {
                socket.setAdapter(Optional.of(new Adapter("DDD"));
            }
        }
    }
}