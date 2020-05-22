public class Jedi {
  ....
        private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.writeObject(new Date());
        stream.defaultWriteObject();
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        Date sysDate = (Date) stream.readObject();
        System.out.println(sysDate);
        stream.defaultReadObject();
    }
}