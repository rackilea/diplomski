MyObject obj = new MyObject();
ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
ObjectOutputStream objectOut = new ObjectOutputStream(byteOutStream);       
objectOut.writeObject(obj);
objectOut.close();

byte[] serializedObject= byteOutStream.toByteArray();
someWSObject.SendObject(DemuxEnum.MyObjectType, serializedObject);