public class ImmutableMessage {
private final int sequenceNumber;
private final List<String> values;

public ImmutableMessage(int sequenceNumber, List<String> values) {
    this.sequenceNumber = sequenceNumber;
    // HERE -- NEXT LINE MAKE SURE THAT THE LIST IS NOT MUTABLE:
    this.values = Collections.unmodifiableList(new ArrayList<String>(values));
}

public int getSequenceNumber() {
    return sequenceNumber;
}

public List<String> getValues() {
    return values;
}
}