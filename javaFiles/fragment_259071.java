private void setTrialMethodByAnnotation() {

    Class<?> clazz = this.getClass();
    Class<TrialMethod> trialMethod = TrialMethod.class;

    Method method = null;
    try {
        method = clazz.getMethod(this.getName(),null);
    } catch (SecurityException e) {
        logger.error(e.getMessage());
    } catch (NoSuchMethodException e) {
        logger.error(e.getMessage());
    }

    if(method.isAnnotationPresent(trialMethod)){
        trialMethodModel.setName(method.getAnnotation(trialMethod).name());
        ...
    }
}