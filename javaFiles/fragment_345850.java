@Produces
public Component createComponent() {
   if (configuration.isSomething()) {
       return new ComponentImpl1();
   } else {
       return new ComponentImpl2();
   }
}