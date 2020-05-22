public void log(Supplier<String> messageSupplier) {
    if (isLogEnabled()) {
        String msg = messageSupplier.get();
        // TODO: log msg
    }
}