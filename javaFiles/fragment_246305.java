ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
Object o = ois.readObject();
if(o instanceof dataStruct) {
   dataStruct ds = (dataStruct)o;
   // do something with ds
}
else {
   // something gone wrong - this should not happen if your
   // socket is connected to the sending side above.
}