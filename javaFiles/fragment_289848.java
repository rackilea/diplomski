public enum PostConstructModule implements Module, TypeListener {

INSTANCE;

@Override
public void configure(final Binder binder) {
    // all instantiations will run through this typeListener
    binder.bindListener(Matchers.any(), this);
}

/**
 * Call postconstruct method (if annotation exists).
 */
@Override
public <I> void hear(final TypeLiteral<I> type, final TypeEncounter<I> encounter) {
    encounter.register(new InjectionListener<I>() {

        @Override
        public void afterInjection(final I injectee) {
            for (final Method postConstructMethod : filter(asList(injectee.getClass().getMethods()), MethodPredicate.VALID_POSTCONSTRUCT)) {
                try {
                    postConstructMethod.invoke(injectee);
                } catch (final Exception e) {
                    throw new RuntimeException(format("@PostConstruct %s", postConstructMethod), e);
                }
            }
        }
    });
   }
  }