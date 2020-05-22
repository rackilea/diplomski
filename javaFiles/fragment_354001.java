public class SerializeInterfaceExample {

   interface Shape extends Serializable {} 
   static class Circle implements Shape { 
      private static final long serialVersionUID = -1306760703066967345L;
   }

   static class ShapeHolder implements Serializable {
      private static final long serialVersionUID = 1952358793540268673L;
      public Shape shape;
   }

   @Test public void canSerializeShape() 
         throws FileNotFoundException, IOException, ClassNotFoundException {
      ShapeHolder circleHolder = new ShapeHolder();
      circleHolder.shape = new Circle();

      ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("test"));
      out.writeObject(circleHolder);
      out.close();

      ObjectInputStream in = new ObjectInputStream(new FileInputStream("test"));
      final ShapeHolder restoredCircleHolder = (ShapeHolder) in.readObject();
      assertThat(restoredCircleHolder.shape, instanceOf(Circle.class));
      in.close();
   }
}