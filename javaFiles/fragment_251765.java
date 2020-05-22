ClassLoader sysClassLoader = Strategie.class.getClassLoader();
URL directory = new URL("file:" + path + "Strategies/Classes/" + strategie + ".jar");
ClassLoader custom = new URLClassLoader(new URL[] {directory}, sysClassLoader);

Class strategieClass = custom.loadClass(className);
Object strategieObject = strategieClass.newInstance();
Strategie strategieInstance= (Strategie) strategieObject;