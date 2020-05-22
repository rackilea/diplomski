class MyValidator implements Validator {
    @Override
    public void validate(Object value)
            throws InvalidValueException {
        if (!(value instanceof String &&
                ((String)value).equals("hello")))
            throw new InvalidValueException("You're impolite");
    }
}


final TextField field = new TextField("Say hello");
field.addValidator(new MyValidator());
field.setImmediate(true);
layout.addComponent(field);