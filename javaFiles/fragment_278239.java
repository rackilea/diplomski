public class AppleHolder implements Serializable{
  static int START_OF_APPLE_MAGIC=120;
  List<Apple> apples=new ArrayList<Apple>();
  double otherData=15;

  private void writeObject(ObjectOutputStream o)
        throws IOException {
    o.writeInt(apples.size());
    for(Apple a: apples) {
      o.write(START_OF_APPLE_MAGIC);
      o.writeObject(a);
    }
    o.writeObject(otherData);
  }

  private void readObject(ObjectInputStream o)
        throws IOException, ClassNotFoundException {
    int appleCount = o.readInt();
    apples = new ArrayList<Apple>(appleCount);
    for(int i=0; i<appleCount; i++) {
      try { 
        while(o.read() != START_OF_APPLE_MAGIC) {
          //fast forward to boundary. Maybe add a max here to avoid infinite loops.
        }
        apples.add((Apple) o.readObject());
      } catch(SomethingWentBadException e) {
        //Add null or nothing or what you want. Look out for failures caused by
        //the value of START_OF_APPLE_MAGIC contained in ordinary fields
        apples.add(null);
      }
    }
    otherData = (double) o.readObject();
  }
}