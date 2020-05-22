private ContributionDef createContributionToMasterObjectProvider() {
  ....
  public void contribute(ModuleBuilderSource moduleSource, 
                ServiceResources resources,
                OrderedConfiguration configuration) {
    ....
    switch (beanMap.size()) {
           case 0:
             return null;
           case 1:
             Object bean = beanMap.values().iterator().next();
             return objectType.cast(bean);
           default:
             Bean annotation = annotationProvider.getAnnotation(Bean.class);
             Object springBean = null;
             String beanName = null;

             if (annotation != null) {
               beanName = annotation.value();
               springBean = beanMap.get(beanName);
             } else {
               String message = String.format(
                 "Spring context contains %d beans assignable to type %s: %s.",
                 beanMap.size(),
                 ClassFabUtils.toJavaClassName(objectType),
                 InternalUtils.joinSorted(beanMap.keySet()));
               throw new IllegalArgumentException(message);
             }
             if (springBean != null) {
               return objectType.cast(springBean);
             } else {
               String message = String.format(
                 "Bean [%s] of type %s doesn't exists. Available beans: %s",
                 beanName, ClassFabUtils.toJavaClassName(objectType),
                 InternalUtils.joinSorted(beanMap.keySet()));
               throw new IllegalArgumentException(message);
             }
           }
         }
       };