public interface SearchableFruit<T>{
    public List<T> searchNewerFruit(T curr); 
}

public class Apple implements SearchableFruit<Apple> {
    public List<Apple> searchNewerFruit(Apple currentApple){
        // impl
    }
}