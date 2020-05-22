public static String replaceStr(String source, String oldSR, String newSR) {
    List<Integer> positions = findPosition(source, oldSR);
    int lengthOldSr = oldSR.length();
    for (Integer position : positions) {
        StringBuilder result = new StringBuilder("");
        int lengthSource = source.length();
        for (int i = 0; i < lengthSource; i++) {
            if (position == i) {
                result.append(newSR);
                i += lengthOldSr - 1;
            } else {
                result.append(source.charAt(i));
            }
        }
        source = result.toString();
    }
    return source;
}

public static List<Integer> findPosition(String source, String oldSR) {
    int lengthOld = oldSR.length();
    int lengthSource = source.length();
    List<Integer> positions = new ArrayList<>();
    for (int i = 0; i < lengthSource; i++) {
        int count = 0;
        for (int j = 0; j < lengthOld; j++) {
            if ((j + i < lengthSource) && source.charAt(j + i) == oldSR.charAt(j)) {
                count++;
            }
        }
        if (count == lengthOld) {
            positions.add(i);
        }
    }
    positions.sort(Comparator.reverseOrder());
    return positions;
}