public static Optional<Adapter> checkAdapterNameOrSetDefaultValue(Optional<Device> device) {
    final Adapter defaultAdapter = new Adapter("DDD");

    return Optional.of(device
            .flatMap(Device::getSocket)
            .map(d -> {
                if (d.getAdapter().isEmpty()) {
                    d.setAdapter(Optional.of(defaultAdapter));
                    return defaultAdapter;
                }
                return d.getAdapter().get();
            })
            .orElseGet(() -> defaultAdapter));
}