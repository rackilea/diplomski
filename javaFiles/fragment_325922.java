private PropertyResolverBean injectedPropertyResolverBean;

void someMethod(Data data){
  if(injectedPropertyResolverBean.getValue("OK"))
    // Do Something

}