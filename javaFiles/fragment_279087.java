Car car = new Car( null, true );

ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
Validator validator = factory.getValidator();
Set<ConstraintViolation<Car>> constraintViolations = validator.validate( car );

assertEquals( 1, constraintViolations.size() );
assertEquals( "may not be null", constraintViolations.iterator().next().getMessage() );