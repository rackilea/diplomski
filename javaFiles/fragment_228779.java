@Component
public class MyObjectToStringList implements Converter<MyObject, String[]>{

    @Override
    public String[] convert(MyObject obj) {
        List<String> items = new ArrayList<>(
                Arrays.asList(
                        obj.get().split("\\r?\\n")));

        items.remove(0);

        return items.toArray(new String[0]);
    }

}