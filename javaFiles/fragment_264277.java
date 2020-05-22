tcDetailsButton.addClickListener(new Button.ClickListener() {

        /**
         * 
         */
        private static final long serialVersionUID = 3726094749730769327L;

        @Override
        public void buttonClick(ClickEvent event) {             

            opener.setResource(new ExternalResource("google.com")); //url
            opener.setWindowName("_blank");                         

        }
});