Map<String, String> messages = new HashMap<String, String>();
for (Validator validator : validators) {
    try {
        validator.validate(value);
    } catch (ValidatorException e) { 
        messages.add(fieldname, e.getMessage());
    }
}