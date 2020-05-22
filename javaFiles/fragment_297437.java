XStream xStream = new XStream() {
        @Override
        public void registerConverter(SingleValueConverter converter, int priority) {
            SingleValueConverter stringPreprocessor = new SingleValueConverterWrapper(converter) {

                @Override
                public Object fromString(String str) {
                    // You can trim whitespace or do other preprocessing here
                    return converter.fromString(str.trim());
                }

            };
            super.registerConverter(stringPreprocessor, priority);
        }
    };