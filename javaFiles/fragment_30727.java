// Use the default application classloader to load the library class
Class artistClazz = Play.application().classloader().loadClass("com.echonest.api.v4.Artist");
// Get the package private constructor that we need
Constructor<Artist> constructor = artistClazz.getDeclaredConstructor(EchoNestAPI.class, Map.class);
// Make sure it's accessible to this class
constructor.setAccessible(true);
return constructor.newInstance(this, (Map) mq.getObject("artist"));