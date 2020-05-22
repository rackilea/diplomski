public class AutoCreateSchemaIntegrator implements Integrator {

  @Override
  public void integrate(Configuration config, SessionFactoryImplementor factory, 
            SessionFactoryServiceRegistry registry) {
    Settings settings = factory.getSettings();

    try {
      Method setter = settings.getClass().getDeclaredMethod("setAutoCreateSchema", boolean.class);
      setter.setAccessible(true);
      setter.invoke(settings, myDeploymentSpecificProperty);
    } catch (ReflectiveOperationException | SecurityException e) {
      // handle exception
    }
  }
}