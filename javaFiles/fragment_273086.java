public enum EmployeeErrorCode {
    DELETE_SUCCESS {
        @Override
        public String toString() {
             return messageSource.getMessage("deleteEmployee.success", null, LocaleContextHolder.getLocale());
        }
    },
    //... Other enumerators

    private MessageSource messageSource;

    static class EnumInitializer {
        @Autowired
        private MessageSource messageSource;

        @PostConstruct
        public void init() {
            for(EmployeeErrorCode errorCode : EmployeeErrorCode.values() {
                errorCode.messageSource = getMessageSource();
            }
        }

        public MessageSource getMessageSource() {
            return messageSource;
        }
    }
}