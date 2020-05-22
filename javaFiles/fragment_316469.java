...
Configuration config = configAdmin.createFactoryConfiguration(
    MyFoo.class.getCanonicalName());
Hashtable<String, String> properties = new Hashtable<>();
properties.put("somebar", new Bar()); // This is where you new
config.update(properties);
// do something useful with the config if you need to update 
// the instance or destroy it later.
...