for (Object object : bindingResult.getAllErrors()) {
    if(object instanceof FieldError) {
        FieldError fieldError = (FieldError) object;

        /**
          * Use null as second parameter if you do not use i18n (internationalization)
          */

        String message = messageSource.getMessage(fieldError, null);
    }
}