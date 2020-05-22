private static Comparator<String> nullSafeStringComparator = Comparator
        .nullsFirst(String::compareToIgnoreCase); 

private static Comparator<Metadata> metadataComparator = Comparator
        .comparing(Metadata::getName, nullSafeStringComparator)
        .thenComparing(Metadata::getValue, nullSafeStringComparator);

public int compareTo(Metadata that) {
    return metadataComparator.compare(this, that);
}