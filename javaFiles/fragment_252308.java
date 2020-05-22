LongSummaryStatistics stat = messages.stream()
    .mapToLong(Message::getOffset).summaryStatistics();
if(stat.getCount()==0 ||
   // all solutions assume that there are no duplicates, in this case,
   // the following test allows to prove that there are no gaps:
   stat.getMax()-stat.getMin()==messages.size()-1) {
    return;
}

if(stat.getMax()-stat.getMin()>Integer.MAX_VALUE) {
    // proceed with array based test
    …
}
else {
    long min = stat.getMin();
    // proceed with BitSet based test
    …