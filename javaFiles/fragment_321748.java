WrapDynaBean wrapDynaBean=new WrapDynaBean(new A());
DynaProperty[] dynaProperties = wrapDynaBean.getDynaClass().getDynaProperties();
List<Object> objects=new ArrayList<>();
for (DynaProperty dynaProperty : dynaProperties) {
    System.out.println(dynaProperty.getName()+" = "+wrapDynaBean.get(dynaProperty.getName()));
    objects.add(wrapDynaBean.get(dynaProperty.getName()));
}
Object[] theArrayYouWant=objects.toArray(new Object[objects.size()]);