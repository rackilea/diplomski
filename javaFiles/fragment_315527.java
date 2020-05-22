public boolean process(Transaction t) {
    if (t.value() == 0) {
        zeroTransCnt++;
        return true;
    }
    else {
        nonzeroTransCnt++;
        return super.process(t);
    }
}