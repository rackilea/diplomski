public void split(int number, int pieces) {
    total = 0;
    dosplit(number, pieces, new ArrayList<Integer>());
}

private void dosplit(int number, int pieces, List<Integer> begin) {
    if (pieces == 1) {
        if (begin.isEmpty() || (number >= begin.get(begin.size() - 1))) {
            begin.add(number);
            total += 1;
            //DO SOMETHING WITH BEGIN
            begin.remove(begin.size() - 1);
        }
    }
    else {
        int start, end;
        start = (begin.isEmpty()) ? 1 : begin.get(begin.size() - 1);
        end = 1 + (1 + number - start)/pieces;
        for(int i=start; i<=end; i++) {
            begin.add(i);
            dosplit(number - i, pieces - 1, begin);
            begin.remove(begin.size() - 1);
        }
    }