Query allusersentityquery = new Query();
allusersentityquery.setAncestor(userKey);

for (final Entity entity : datastore.prepare(allusersentityquery).asIterable()) {
    Map<String, Object> properties = entity.getProperties();
    String[] propertyNames = properties.keySet().toArray(
        new String[properties.size()]);

    for(final String propertyName : propertyNames) {
      // propertyNames string contains
      // "com.google.appengine.api.datastore.PostalAddress" if it is a Postal Address
    }
}