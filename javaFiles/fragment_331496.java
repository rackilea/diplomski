public void saveOrUpdate(IEntity<?> entity) {
      try {
          if(entity.getId == null) {
            em.persist(entity);
          } else {
            em.merge(entity)l
          }
      } catch(ConstraintViolationException cve) {
          throw new ConstraintViolationEx(constructViolationMessage(cve.getConstraintViolations()));
      }
  }

 private String constructMessage(Set<ConstraintViolation<?>> pConstraintViolations) {
    StringBuilder customMessages = new StringBuilder();
    for(ConstraintViolation<?> violation : pConstraintViolations) {
        String targetAnnotation = violation.getConstraintDescriptor().getAnnotation().annotationType().getSimpleName();
        if(supportsCustomMessage(targetAnnotation)) {
            applyMessage(violation, targetAnnotation, customMessages);
        } else {
            // do something with not customized constraints' messages e.g. append it to existing container
        }
    }
    return customMessages.toString();
 }

 private void applyMessage(ConstraintViolation<?> pViolation, String pTargetAnnotation, StringBuilder pCustomMessages) {
     String targetClass = pViolation.getRootBean().getClass().getName();
     String targetField = pViolation.getPropertyPath().toString();
     pCustomMessages.append(MessageFormat.format(getMessageByAnnotation(pTargetAnnotation), targetClass, targetField));
     pCustomMessages.append(System.getProperty("line.separator"));
 }


 private String getBundleKey() {
     return "ValidationMessages"; //FIXME: hardcoded - implement your true key
 }

 private String getMessageByAnnotation(String pTargetAnnotation) {
     ResourceBundle messages = ResourceBundle.getBundle(getBundleKey());
     switch(pTargetAnnotation) {
     case "NotNull":
         return messages.getString(pTargetAnnotation + ".message");
     default:
         return "";
     }
 }

 private boolean supportsCustomMessage(String pTargetAnnotation) {
     return customizedConstraintsTypes.contains(pTargetAnnotation);
 }