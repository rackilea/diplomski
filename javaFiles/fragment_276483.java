import java.io.File;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;

public class URLClassLoaderSample {
  public static void main( String [] args ) throws Exception {
    File f = new File( "/home/ravinder/Desktop/mysql-connector-java-5.1.18-bin.jar" );
    URLClassLoader urlCl = new URLClassLoader( new URL[] { f.toURL() }, System.class.getClassLoader() );

    Class mySqlDriver = urlCl.loadClass( "com.mysql.jdbc.Driver" );
    System.out.println( mySqlDriver.newInstance() );
    System.out.println( "Is this interface? = " + mySqlDriver.isInterface() );

    Class interfaces[] = mySqlDriver.getInterfaces();
    int i = 1;
    for( Class _interface : interfaces ) {
        System.out.println( "Implemented Interface Name " + ( i++ ) + " = " + _interface.getName() );
    } // for(...)

    Constructor constructors[] = mySqlDriver.getConstructors();
    for( Constructor constructor : constructors ) {
        System.out.println( "Constructor Name = " + constructor.getName() );
        System.out.println( "Is Constructor Accessible? = " + constructor.isAccessible() );
    } // for(...)
  } // psvm(...)
} // class URLClassLoaderSample