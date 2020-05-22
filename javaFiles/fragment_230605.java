public class Response<T extends Fruit> {
    private List<T> mFruitList;
    public List<T> getFruitList() {
        return mFruitList;
    }
} 

Response<Orange> response = // create
List<Orange> oranges = response.getFruitList();