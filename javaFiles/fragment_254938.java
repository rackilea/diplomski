HibernateValidatorConfiguration configuration = Validation
    .byProvider( HibernateValidator.class )
    .configure();

ConstraintMapping constraintMapping = configuration.createConstraintMapping();

constraintMapping
    .type( ExternalClass.class )
        .property( "someProperty", FIELD )
            .constraint( new NotNullDef() )
            .constraint( new SizeDef().min( 2 ).max( 14 ) )
    .type( AnotherExternalClass.class )
        .property( "anotherProperty", METHOD )
            .constraint( new NotNullDef() );

Validator validator = configuration.addMapping( constraintMapping )
    .buildValidatorFactory()
    .getValidator();