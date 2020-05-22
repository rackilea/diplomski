/**
* Create a new instance of the factory.
* This static method creates a new factory instance. 
* This method uses the following ordered lookup procedure to determine 
* the XMLInputFactory implementation class to load: 
* Use the javax.xml.stream.XMLInputFactory system property. 
* Use the properties file "lib/stax.properties" in the JRE directory. 
* This configuration file is in standard java.util.Properties format and contains 
* the fully qualified name of the implementation class with the key being the system property defined above. 
* Use the Services API (as detailed in the JAR specification), if available, to determine the classname. 
* The Services API will look for a classname in the file META-INF/services/javax.xml.stream.XMLInputFactory 
* in jars available to the runtime. 
* Platform default XMLInputFactory instance. 
* Once an application has obtained a reference to a XMLInputFactory 
* it can use the factory to configure and obtain stream instances. 
*
* @throws FactoryConfigurationError if an instance of this factory cannot be loaded
*/
public static XMLInputFactory newInstance()
  throws FactoryConfigurationError
{
    return (XMLInputFactory) FactoryFinder.find(
  "javax.xml.stream.XMLInputFactory",
  "com.sun.xml.internal.stream.XMLInputFactoryImpl");
}