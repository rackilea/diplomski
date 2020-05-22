class MyController {

  MessageSource messageSource
  LocaleResolver localeResolver

    def myAction(Book book) {
        Locale locale = localeResolver.resolveLocale(request)

        if (!book.validate()) {
            List allErrorMessages = book.errors.allErrors.collect {
                messageSource.getMessage(it, locale)
            }

            // print all error messages
            println allErrorMessages
        }
    }
}