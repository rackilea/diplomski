int dynamicallyCalculatedConstraintValue = ...;

ConstraintMapping mapping = new ConstraintMapping();
mapping.type( MyBean.class )
  .property( "mininumAge", FIELD )
    .constraint( new MaxDef().value( dynamicallyCalculatedConstraintValue ) );

HibernateValidatorConfiguration config = Validation.byProvider( HibernateValidator.class ).configure();
config.addMapping( mapping );
Validator validator = config.buildValidatorFactory().getValidator();