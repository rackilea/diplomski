class bar {
    ...

    private void writeObject(ObjectOutputStream stream) throws IOException {
      // let version 1, later when you need to have versioning. 
      stream.writeInt(version);
      stream.writeInt(i);
      // leave out 
      // stream.writeObject(foo);

    }
}
// read object the analog, see