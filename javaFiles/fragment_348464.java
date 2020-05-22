public String mostCommon(StringList a) {
    String previous = null;
    int bestCount = 0;
    int count = 1;
    String bestString = null;

    for (int i = 0; i < a.size(); i++) {
        if (a.get(i).equals(previous)) { 
            count++;
        }
        else {
            count = 1;
        }

        if (count > bestCount) {
            bestCount = count;
            bestString = a.get(i);
        }

        previous = a.get(i);
    }

    return bestString;
}