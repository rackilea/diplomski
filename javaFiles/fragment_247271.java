public class Example {
    final private ArrayList<String> list;

    Example(ArrayList<String> listArg) {
        list = Collections.unmodifiableList(listArg);
    }
}