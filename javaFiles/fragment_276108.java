public InputStream exportAsCsv(CqlQuery query) {
    Iterator<String> result = queryService.execute(.....);
    return new SequenceInputStream(asStreamEnum(result));
}   

private Enumeration<InputStream> asStreamEnum(final Iterator<String> it) {
    return new Enumeration<InputStream>() {

        @Override
        public boolean hasMoreElements() {
            return it.hasNext();
        }

        @Override
        public InputStream nextElement() {
            try {
                return new ByteArrayInputStream(it.next().getBytes("UTF-8"));
            } catch (UnsupportedEncodingException ex) {
                throw new RuntimeException(ex);
            }
        }

    };
}