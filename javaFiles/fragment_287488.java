ResourceBundle rootOnly = ResourceBundle.getBundle("labels",
    new ResourceBundle.Control() {
        @Override
        public List<Locale> getCandidateLocales(String name,
                                                Locale locale) {
            return Collections.singletonList(Locale.ROOT);
        }
    });