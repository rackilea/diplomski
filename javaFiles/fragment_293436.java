public enum InitechStatus{
        OPEN("open"), CLOSED("closed"), BROKEN("broken");

        private static ResourceBundle resourceBundle = ResourceBundle.getBundle("messages",
                Locale.ENGLISH);

        public final String name;
        @Autowired
        private MessageSource messageSource;

        InitechStatus(String name) {
            this.name = name;
        }

        @Override
        public String toString() {

            String displayStatusString = resourceBundle.getString("page.systemadministration.broadcastmail.status."
                    + this.name);
            return displayStatusString;
        }


    }