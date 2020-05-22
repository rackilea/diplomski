xStream.registerConverter(new IntConverter() {
        @Override
        public Object fromString(String str) {
            return super.fromString(str.trim());
        }

    });