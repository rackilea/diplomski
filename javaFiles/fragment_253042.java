for (Class<?> test : testClasses) {
    BeanGenerator beanGenerator = new BeanGenerator ();
    beanGenerator.setSuperclass (test);
    beanGenerator.addProperty("student", Student.class);
    Object myBean = (test) beanGenerator.create();  
    Method setter = myBean.getClass().getMethod("setStudent", Student.class);
    setter.invoke(myBean, new Student()); 
}