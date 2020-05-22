protected void forceAgentHeader(final String header) throws Exception {
    final Class<?> clazz = Class
            .forName("sun.net.www.protocol.http.HttpURLConnection");

    final Field field = clazz.getField("userAgent");
    field.setAccessible(true);
    Field modifiersField = Field.class.getDeclaredField("modifiers");
    modifiersField.setAccessible(true);
    modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
    field.set(null, header);
}