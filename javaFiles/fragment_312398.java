String error = messageSource.getMessage("BadParsingFormat",
            new Object[]{
                    messageSource.getMessage(exception.getVariableName(),null, null),
                    exception.getLowerBound(),
                    exception.getUpperBound()
            });