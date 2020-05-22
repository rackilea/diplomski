ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bous.toByteArray())) {
    Set<ClassLoader>    lhs = new LinkedHashSet<ClassLoader>();
    {
        // Keep a set if discovered class loaders
        lhs.add(getClass().getClassLoader());
    }

    @Override
    protected Class< ? > resolveClass(ObjectStreamClass desc) 
         throws ClassNotFoundException, IOException {

         for (ClassLoader cl : lhs) try {
             Class< ? > c = cl.loadClass(name);

             // we found the class, so we can use its class loader,
             // it is in the proper class space  if the uses constraints 
             // are set properly (and you're using bnd so you should be ok)

             lhs.add(c.getClassLoader());

             // The paranoid among us would check
             // the serial uuid here ...
             // long uuid = desc.getSerialVersionUID();
             // Field field = c.getField("serialVersionUID");
             // assert uuid == field.get(null)

             return c;
         } catch (Exception e) {
           // Ignore
         }

         // Fallback (for void and primitives)
         return super.resolveClass(desc);
     }
 };

 // And now we've successfully read the object ...

 A clone = (A) in.readObject();