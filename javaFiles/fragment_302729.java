Query q = entityManager.createNamedQuery("MyEntity.findAll");
List entityObjects = q.getResultList();

ClassLoader loader1 = 
    com.xyz.abc.services.persistence.entity.MyEntity.getClass().getClassLoader();
System.out.println("MyEntity's class loader is " + loader1);
for (Object entityObject: entityObjects) {
  ClassLoader loader2 = entityObject.getClass().getClassLoader();
  System.out.println("Class loader of entity " + entityObject + " is " + loader2);
}