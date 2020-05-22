@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Transactional(value = "Custom", readOnly = true, propagation = Propagation.REQUIRED)
public @interface CustomTransactionalWithRequired {
}

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Transactional(value = "Custom", readOnly = true, propagation = Propagation.SUPPORTED)
public @interface CustomTransactionalWithSupported {
}