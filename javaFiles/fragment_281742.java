/**
 * Mimic GUICE's ability to satisfy injection points automatically,
 * without needing to explicitly bind every class, and without needing
 * to add an extra build step.
 */
@Service
public class JustInTimeServiceResolver implements JustInTimeInjectionResolver {

    @Inject
    private ServiceLocator serviceLocator;

    @Override
    public boolean justInTimeResolution( Injectee injectee ) {
    final Type requiredType = injectee.getRequiredType();

        if ( injectee.getRequiredQualifiers().isEmpty() && requiredType instanceof Class ) {
            final Class<?> requiredClass = (Class<?>) requiredType;

            // IMPORTANT: check the package name, so we don't accidentally preempt other framework JIT resolvers
            if ( requiredClass.getName().startsWith( "com.fastmodel" )) {
                final List<ActiveDescriptor<?>> descriptors = ServiceLocatorUtilities.addClasses( serviceLocator, requiredClass );

                if ( !descriptors.isEmpty() ) {
                    return true;
                }
            }
        }
        return false;
    }
}