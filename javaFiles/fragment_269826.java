Map<String, Boolean> entityPropNullables = new HashMap<String, Boolean>();
// Provide the class of disired metadata as parameter
ClassMetadata entityMeta = getSessionFactory().getClassMetadata(anEntityClass);
String[] propNames = entityMeta.getPropertyNames();
boolean[] isNullableProps = entityMeta.getPropertyNullability();

if (propNames != null) {
    for (int i = 0; i < propNames.length; i++ ) {
        entityPropNullables.put(propNames[i], isNullableProps[i]);
    }
}