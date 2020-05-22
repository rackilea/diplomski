InputStream is = socket.getInputStream();   
   ObjectInputStream ois = new ObjectInputStream(is);   
   MyObject obj = (MyObject)ois.readObject();  
   //Now use the object

    Where:  
    class MyObject implements Serializable {  
      //variables
    }