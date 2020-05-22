public Object getThing(final Object arg) {
    return new Object() {
        private String str = arg.toString();
        public String getStr() {
            return this.str;
        }
    };
}