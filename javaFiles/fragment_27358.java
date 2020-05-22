binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(
org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE,
 myBean1, 
org.jdesktop.beansbinding.ELProperty.create("${fileLocation}"), 
jTextField12, 
org.jdesktop.beansbinding.BeanProperty.create("text"), 
"fileLocation");
bindingGroup.addBinding(binding);