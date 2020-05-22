@Override public void validate() {
    // Allow the parent class to validate first...
    super.validate();
    // ... then perform child-specific validation
    if (someChildField == 0) {
        throw new SomeValidationException("...");
    }
}