class PayloadA extends Payload {
    private String guid;
    private String deviceId;
    private String langId;
    private String sessionId;

    private PayloadA() {
        //avoid direct instantiation
    }

    public static class Builder {

        private String guid;
        private String deviceId;
        private String langId;
        private String sessionId;

        public Builder setLangId(String langId) {
            this.langId = langId;
            return this;
        }

        public Builder(String deviceId) {
            //validations
            this.deviceId = deviceId;
        }

        public PayloadA build() {
            //validations
            return new PayloadA();
        }

        //other setters returning this Builder
    }
}