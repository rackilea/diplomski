public <T> List<T> get(final String key, final Class<T> t) {
  Class<?> propClass = propClasses.get( key );                  
  if( propClass == null || t == null || !t.equals( propClass )  ) {
    return null;
  }

  return (List<T>)properties.get(key);        
}