@Override
protected String doInBackground(String... data) {
    /* set up the socket/DataInputStream, etc. and whatever else you need
       in the background */ 
    DataInputStream in = ...;
    return in.readUTF();
}