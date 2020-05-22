for (ConstraintViolation<TestBean> violation : constraintViolations) {
    Set<Class<? extends Payload>> payloads = violation.getConstraintDescriptor().getPayload();
    for (Class<? extends Payload> payload : payloads) {
        if (payload == Severity.Error.class) {
            // logic here   
        }
    }
}