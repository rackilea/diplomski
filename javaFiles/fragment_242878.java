public class Vector<T>{

[…]
    public void prepend(T element){
        this.next = new Vector<>(value, next); // a Copy Constructor would also be fine
        this.value = element;
    }
}