public class IntegerListToStringList implements Functor<List<Integer>, List<String>> {
    @Override
    public List<String> map(List<Integer> integerList) {
        List<String> stringList = new ArrayList<>(integerList.size());
        for(Integer intValue : integerList) {
            stringList.add(Integer.toString(intValue));
        }
        return stringList;
    }
}