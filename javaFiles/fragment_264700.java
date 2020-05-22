public void uniqueKey() {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

    ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    ValidatorContext validatorContext = validatorFactory.usingContext();
    validatorContext.constraintValidatorFactory(new ConstraintValidatorFactoryImpl(entityManagerFactory));
    Validator validator = validatorContext.getValidator();

    EntityManager em = entityManagerFactory.createEntityManager();

    User se = new User("abc", poizon);

       Set<ConstraintViolation<User>> violations = validator.validate(se);
    System.out.println("Size:- " + violations.size());

    em.getTransaction().begin();
    em.persist(se);
    em.getTransaction().commit();

        User se1 = new User("abc");

    violations = validator.validate(se1);

    System.out.println("Size:- " + violations.size());
}