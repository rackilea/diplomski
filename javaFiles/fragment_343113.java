for (BeanDefinition component : components){

   cls = Class.forName(component.getBeanClassName());

   if (!cls.isAnnotationPresent(Deprecated.class) {
      classList.add(cls.getName().toString());
   }
}