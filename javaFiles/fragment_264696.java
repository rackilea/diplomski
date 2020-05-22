public class ConstraintValidatorFactoryImpl implements ConstraintValidatorFactory {

    private EntityManagerFactory entityManagerFactory;

    public ConstraintValidatorFactoryImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public <T extends ConstraintValidator<?, ?>> T getInstance(Class<T> key) {
        T instance = null;

        try {
            instance = key.newInstance();
        } catch (Exception e) { 
            // could not instantiate class
            e.printStackTrace();
        }

        if(EntityManagerAwareValidator.class.isAssignableFrom(key)) {
            EntityManagerAwareValidator validator = (EntityManagerAwareValidator) instance;
            validator.setEntityManager(entityManagerFactory.createEntityManager());
        }

        return instance;
    }
}