interface AnimalFactory {
   Rooster getAnimal();
 }
 ...
 protected void configure() {
   install(new GinFactoryModuleBuilder().build(AnimalFactory.class));
 }