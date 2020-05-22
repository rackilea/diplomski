private boolean finished(List<Integer> list) {
    int len = list.length();

    // check for minimum of 6 entries
    if(len < 6) {
        return false;
    }

    return list.get(len-1) == 1
        && list.get(len-2) == 2
        && list.get(len-3) == 4
        && list.get(len-4) == 1
        && list.get(len-5) == 2
        && list.get(len-6) == 4;
}