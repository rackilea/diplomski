// assume rangesToBeRemoved has been sorted
public static Set<Integer> addElementbyRemovedRanges(Range outer, List<Range> rangesToBeRemoved ) {

    Set<Integer> outerElements = new HashSet<Integer>();

    // this variable record the last element that has handled and act like a borderline
    int borderElementIndex = outer.start-1;
    for (Range range : rangesToBeRemoved) {
        if (range.end <= borderElementIndex ) {
            // omit this range as it has been cover by previous range(s)
            continue;
        }

        // add range if there is gap between range
        if (range.start > borderElementIndex ) {
            addElements(outerElements, borderElementIndex + 1, range.start - 1);
        }

        // update borderline
        borderElementIndex = range.end;
    }
    // Add all element after the last range's end
    addElements(outerElements, borderElementIndex + 1, outer.end);

    return outerElements;
}

public static void addElements(Set<Integer> outerElements, int start, int end) {
    if (start > end) {
        return;
    }
    for (int i=start; i<=end; i++){
        outerElements.add(i);
    }
}