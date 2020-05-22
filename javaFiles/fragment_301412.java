public void marshallObject(Object obj, ObjectOutputStream stream) {
    try {
        stream.writeObject(new MarshalledObject<Object>(obj));
        stream.close();
    } catch (IOException e) {
        System.out.println("Exception:" + e); 
    }
}

public Object unmarshallObject(ObjectInputStream stream) {      
    MarshalledObject<Object> object = null;
    try {
        object = stream.readObject();
    } catch (Exception e) {
        System.out.println("Exception:" + e);
    }
    return (object != null) ? object.get() : null;
}