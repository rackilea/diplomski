public class DuplicateBeanDetectionBeanPostProcessor implements BeanPostProcessor{

    private Map<Class<?> , Boolean> beanTypeFound = new HashMap<Class<?> , Boolean>();

    private Set<Class<?> typesToRestrictToOneInstance = new HashSet<Class<?>>();

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException{
    return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException{
    Set<Class<?>> restrictedTypesForBean = findRestrictedTypesForInstance(bean);
    if(!restrictedTypeForBean.isEmpty() && typeAlreadyFound(bean , restrictedTypesForBean)){
       throw new IllegalStateException("Bean of type : " + restrictedTypeForBean + " already found in the application context";
    }
    return bean;
    }

    private Set<Class<?>> findRestrictedTypesForInstance(Object bean){
      Set<Class<?>> restrictedTypesForBean = hew HashSet<>();
      Class<?> superClass = bean.getClass();
    while(superClass != null){
       for(Class<?> restrictedType : typesToRestrictToOneInstance){
          if(restrictedType.isAssignableFrom(superClass){
               restrictedTypesForBean.add(restrictedType);
          }
       }
    }
    return restrictedTypesForBean;
    }

    private boolean typeAlreadyFound(Object bean , Set<Class<?>> restrictedTypesForBean){
    for(Class<?> restrictedTypeForBean : restrictedTypesForBean){
        if(beanTypeFound.get(restrictedTypeForBean)){
            return true;
        }
        else{
           beanTypeFound.set(restrictedTypeForBean , true);
        }
    }
    return false;
    }

    public void setTypesToRestrictToOneInstance(Set<Class<?>> typesToRestrictToOneInstance){
   this.typesToRestrictToOneInstance = typesToRestrictToOneInstance;
}
}