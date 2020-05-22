// here I need to deserialize
    public DataWork deserialize(byte[] buffer) {

       if(null == buffer || buffer.length == 0)
             return null;

       // reconstruct the string back from bytes.
       String data = new String(buffer);

       // now just parse the string and create a new object of type DataWork 
       // with clientID and serverID field values retrieved from the string.
       String splitData = data.split(",");

       String clientID = splitData[0].split("=")[1];
       String serverID = splitData[1].split("=")[1];    

       return new DataWork(clientID, serverID.substring(0, serverID.length() -1));
    }