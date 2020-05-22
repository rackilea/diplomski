private enum Auth {

    KEY {
        public String get() {
            return "mykey";
        } 
    },

    PASSWORD {
        public String get() {
            return "mypassword";
        } 
    },

    MAIL {
        public String get() {
            return "mymail";
        } 
    };

    public abstract String get();

}