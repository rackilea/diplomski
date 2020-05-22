public interface Function<S, T> {
    T apply(S in);
}

abstract class MappingClass<S, T> {
    protected List<T> map(List<S> list, Function<S, T> fun) {
        List<T> result = new ArrayList<T>();
        for(T item : list) {
            result.add(fun.apply(item));
        }
    }
}

class MultipleByTwoIteration extends MappingClass {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2 ,3, 4, 5, 6);

        List<Integer> multipledByTwo = map(numbers, 
                new Function<Integer, Integer>() {
            public Integer apply(Integer in) {
                return in * 2;
            }
        });
    }
}