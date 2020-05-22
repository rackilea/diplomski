Map<Class<? extends OldConnection>, Class<? extends NewConnection>> mapping; //initializing is up to you

public NewConnection  createIConnectedSubtypeInstance(OldConnection connection) {
  try {
    Class<? extends NewConnection> subtype = mapping.get( connection.getClass() );
    return subtype.getConstructor( connection.getClass() ).newInstance( connection );
  } catch( Exception e) { //you might want to catch the more specific types
    //handle appropriateley
  }
}