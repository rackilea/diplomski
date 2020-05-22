public void computeMedian() {
    Arrays.sort(list);
    if ( (list.size & 1) == 0 ) {
        // even: take the average of the two middle elements
        median = (list[(size/2)-1] + list[(size/2)]) / 2;
    } else {
        // odd: take the middle element
        median = list[size/2];
    }
}

public void computeMode() {
    // precondition: The list array has exactly 1 mode.
    Map<Integer, Integer> values = new HashMap<Integer, Integer>();
    for (int i=0; i < list.size; ++i) {
        if (values.get(list[i]) == null) {
            values.put(list[i], 1);
        } else {
            values.put(list[i], values.get(list[i])+1);
        }
    }

    int greatestTotal = 0;

    // iterate over the Map and find element with greatest occurrence
    Iterator it = values.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry pair = (Map.Entry)it.next();
        if (pair.getValue() > greatestTotal) {
            mode = pair.getKey();
            greatestTotal = pair.getValue();
        }
        it.remove();
    }
}