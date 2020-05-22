@Override
public void logIfEnabled(final String fqcn, final Level level, final Marker marker, final String message,
            final Supplier<?>... paramSuppliers) {
        if (isEnabled(level, marker, message)) {
            logMessage(fqcn, level, marker, message, paramSuppliers);
        }
}