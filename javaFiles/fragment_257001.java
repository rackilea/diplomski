public class BoxDemo {
  public static <U> void addBox(U u, List<Box<U>> boxes) {
  Box<U> box = new Box<>();
  box.set(u);
  boxes.add(box);
  }
}