public static void rejectErrors(final BindingResult result, final List<String> errors) {
    if (errors != null) {
        for (final String error : errors) {
            result.reject(error);
        }
    }
}