// this generally returns the PWD
String pwd = System.getProperties().getProperty("user.dir"); 

// or you can get the location of the URL
// from the .jar file in which your class was loaded
// you may want to then simply back it up a level with ".."
URL yourJar = getClass().getProtectionDomain().getCodeSource().getLocation();