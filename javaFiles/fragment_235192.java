try (InputStream inputStream = externalService.getObject().getInputStream()) {
    // further uses of inputStream
} catch (Exception e) {
    // ... logging etc
    throw e;
}