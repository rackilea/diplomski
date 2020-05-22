Manifest-Version: 1.0
Bundle-ManifestVersion: 2
Bundle-Name: ReflectivePlugin
Bundle-SymbolicName: ReflectivePlugin
Bundle-Version: 1.0.0.qualifier
Bundle-Activator: reflectiveplugin.Activator
Bundle-ActivationPolicy: lazy
Bundle-RequiredExecutionEnvironment: JavaSE-1.6
Import-Package: javax.annotation;version="1.0.0",
 org.osgi.framework;version="1.3.0",
 org.osgi.service.log;version="1.3",
 org.osgi.util.tracker;version="1.3.1"
Bundle-ClassPath: .,
 lib/dom4j-1.6.1.jar,
 lib/guava-r08.jar,
 lib/javassist-3.12.1.GA.jar,
 lib/reflections-0.9.5.jar,
 lib/slf4j-api-1.6.1.jar,
 lib/xml-apis-1.0.b2.jar
Export-Package: reflectiveplugin, 
 reflectiveplugin.data