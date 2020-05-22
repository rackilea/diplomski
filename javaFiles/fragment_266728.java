ValidatorFactory validatorFactory = Validation
            .byDefaultProvider()
            .configure()
            .ignoreXmlConfiguration()
            .messageInterpolator(new MessageInterpolator() {
                @Override
                public String interpolate(String messageTemplate, Context context) {
                    int id = ApplicationContext.getApplication().getResources().getIdentifier(messageTemplate, "string", R.class.getPackage().getName());
                    return ApplicationContext.getApplication().getString(id);
                }

                @Override
                public String interpolate(String messageTemplate, Context context, Locale locale) {
                    return interpolate(messageTemplate, context);
                }
            })
            .buildValidatorFactory();