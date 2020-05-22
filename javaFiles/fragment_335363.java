public I removeFirst() {
    I removed = first.get(0);
    if(size()==3) {
        first = first.getAfter();
        first.setBefore(null);
        first.setAfter(last);
        return removed;
    } else if(size()==2) {
        first = first.getAfter();
        first.setBefore(null);
        first.setAfter(null);
        return removed;
    }else {
        first = null;
        first.setBefore(null);
        first.setAfter(null);
        return removed;
    }

}