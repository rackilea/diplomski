private static class SerializerWithPreprocessor extends Persister {

        public SerializerWithPreprocessor(RegistryMatcher matcher, Format format) {
            super(matcher, format);
        }

        @Override
        public <T> T read(Class<? extends T> type, String source) throws Exception {
            source = source.replaceFirst("<Command (.*)>([[\\w||[+=]]&&[^<>]]+)</Command>", "<Command $1><Content>$2</Content></Command>");
            return super.read(type, source);
        }
    }