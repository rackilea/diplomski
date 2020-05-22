public class Container<E> {
     private E item;
     public E getItem() {return item;}
}
class BoxWithPresent extends Container<Present> {
}
class SimpleBox extends Container {
}