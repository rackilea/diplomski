private static int calculateCount(String eqPart) {
    Matcher matcher = Pattern.compile("(\\d*) ([A-Z]\\w*)").matcher(eqPart);
    int totalCount = 0;
    while (matcher.find()) {
        String moleculeCountStr = matcher.group(1);
        int moleculeCount = moleculeCountStr.isEmpty() ? 1 : Integer.parseInt(moleculeCountStr);
        String molecule = matcher.group(2);
        Matcher moleculeMatcher = Pattern.compile("[A-Z][a-z]*(\\d*)").matcher(molecule);
        while (moleculeMatcher.find()) {
            String atomCountStr = moleculeMatcher.group(1);
            int atomCount = atomCountStr.isEmpty() ? 1 : Integer.parseInt(atomCountStr);
            totalCount += moleculeCount * atomCount;
        }
    }
    return totalCount;
}