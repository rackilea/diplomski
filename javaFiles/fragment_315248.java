ClassMetadata meta = sessionFactory.getClassMetadata(entity.getClass());
String[] propertyNames = meta.getPropertyNames();
boolean[] propertyLaziness = meta.getPropertyLaziness();

for (int i = 0; i < propertyNames.length; i++) {
    String propertyName = propertyNames[i];

    // Check if the property fetch type is Lazy
    if (propertyLaziness[i]) {
        System.out.println("Property : " + propertyName + " fetch type is Lazy");
    }
}