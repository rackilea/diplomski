@Inject
public StepProcessor(Set<IParser> parsers) { //Inject a set of IParser
    if (parsers == null) {
        throw new IllegalArgumentException("Parsers cannot be null");
    }
    this.parsers = parsers;
}

@Override
public void process( String name ) {
    for (IParser parser : parsers) {
        System.out.println(parser.getName());
    }
}