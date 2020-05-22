public class MappedJarClassLoader extends ClassLoader {
     Map<String,byte[]> map = new HashMap<>();

     public MappedJarClassLoader (ClassLoader parent, Map<String,byte[]> map) {
         super(parent);
         this.map = map;
     }

     public Class findClass(String name) throws ClassNotFoundException {
         byte[] b = map.get(name.replace('/', '$').replace('.', File.separatorChar));
         if(b == null)
             throw new ClassNotFoundException(name);
         return defineClass(name, b, 0, b.length);
     }
}