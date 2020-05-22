public <T> List<? extends T> getReadOnly(final String key, final Class<T> t) {
  Class<?> propClass = propClasses.get( key );          
  if( propClass == null || t == null || !t.isAssignableFrom( propClass ) ) {
    return null;
  }

  return (List<? extends T>)properties.get(key);        
}