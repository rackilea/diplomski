instance.subscribeMessage("yep", new BinaryFunction() {
        @Override
        public String invoke(Object a, Object b) {
            return MessageFormat.format("{0}/{1}", a, b);
        }
    });