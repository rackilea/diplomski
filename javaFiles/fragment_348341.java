public static void main(String[] args) throws Exception {
    Area area = new Area(new Rectangle(0, 0, 100, 100)); // The original object, NOT SERIALIZABLE !
    System.out.println(area.contains(new Rectangle(1, 1, 10, 10))); // Good as new !
    System.out.print("serializing...");
    byte[] pojoBytes = Serializer.serialize(area); // Serialize
    System.out.println("done");
    System.out.print("deserializing...");
    area = (Area) Serializer.deserialize(pojoBytes); // Deserialize
    System.out.println("done");
    System.out.println(area.contains(new Rectangle(1, 1, 10, 10))); // Good as new !
}