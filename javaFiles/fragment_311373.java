import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

private static SessionFactory buildSessionFactory() {
  Configuration configuration = new Configuration();
  configuration.configure();
  configuration.addAnnotatedClass(Employee.class);
  ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
  return configuration.buildSessionFactory(serviceRegistry);
}