public static class OptionParser<T> implements ParameterParser {

    private final String option;

    public OptionParser(String option, Function<String, ? extends T> parser) {
        if (parser == null) {
            throw new IllegalArgumentException();
        }
        this.option = "-" + option;
        this.parser = parser;
    }

    public OptionParser(String option, Function<String, ? extends T> parser, T defaultValue) {
        this(option, parser);
        this.value = defaultValue;
    }

    private final Function<String, ? extends T> parser;

    private T value;

    @Override
    public int parse(String[] args, int index) {
        if (args.length < index + 2 || !option.equals(args[index])) {
            return index;
        } else {
            value = parser.apply(args[index + 1]);
            return index + 2;
        }
    }

    public T getValue() {
        return value;
    }

}

public static interface ParameterParser {


    /**
     * Tries parsing the parameter and returns the new index after the
     * operation.
     *
     * @param args the parameter list
     * @param index the index of the first String to use.
     * @return the index of the next String after parsing the parameter or the index,
     * if the parameter wasn't parsable with this ParameterParser.
     */
    public int parse(String[] args, int index);
}

public static void main(String[] args) {
    OptionParser<String> shape = new OptionParser<>("shape", Function.identity(), "polygon");
    OptionParser<String> color = new OptionParser<>("color", Function.identity(), "green");
    OptionParser<Integer> repeat = new OptionParser<>("repeat", Integer::valueOf, 5);
    OptionParser<String> name = new OptionParser("name", Function.identity());

    List<ParameterParser> parameters = Arrays.asList(
            shape,
            color,
            repeat,
            name
    );

    Iterator<ParameterParser> iterator = parameters.iterator();

    for (int i = 0; i < args.length;) {
        if (!iterator.hasNext()) {
            throw new IllegalArgumentException("could not parse option at index " + i + ": " + args[i]);
        }
        i = iterator.next().parse(args, i);
    }

    if (name.getValue() == null) {
        throw new IllegalArgumentException("-name is required");
    }

    System.out.println("shape="+shape.getValue());
    System.out.println("color="+color.getValue());
    System.out.println("repeat="+repeat.getValue());
    System.out.println("name="+name.getValue());