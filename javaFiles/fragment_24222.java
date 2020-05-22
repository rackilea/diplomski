ClientSerializationStreamWriter streamWriter = ...;//create with serializer
streamWriter.prepareToWrite();
streamWriter.writeString("com.acme.project.shared.MyService");//service interface
streamWriter.writeString("filterStrings");//method name
streamWriter.writeInt(2);//number of arguments to be found in the stream
streamWriter.writeObject(strings);
streamWriter.writeString(startsWith);