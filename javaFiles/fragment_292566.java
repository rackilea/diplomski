@Autowired
private Validator validator;

// ...

public void validate(Object a, Class<?>... groups) {
    Set<ConstraintViolation<Object>> violations = validator.validate(a, groups);
    if(!violations.isEmpty()) {
        throw new ConstraintViolationException(violations);
    }
}

// ...

validate(buyer, "foo".equals(buyer.getMethod()) 
                    ? FooValidation.class 
                    : NotFooValidation.class);