String serializedObject = "";

 // serialize the object
 try {
     ByteArrayOutputStream bo = new ByteArrayOutputStream();
     ObjectOutputStream so = new ObjectOutputStream(bo);
     so.writeObject(myObject);
     so.flush();
     serializedObject = bo.toString();
 } catch (Exception e) {
     System.out.println(e);
 }

 // deserialize the object
 try {
     byte b[] = serializedObject.getBytes(); 
     ByteArrayInputStream bi = new ByteArrayInputStream(b);
     ObjectInputStream si = new ObjectInputStream(bi);
     MyObject obj = (MyObject) si.readObject();
 } catch (Exception e) {
     System.out.println(e);
 }