boolean bFDone = false;
boolean bRunMap = false;

synchronized (c) {
    bFDone = !items.hasNext() && (c.getFinishedCount() == c.getStartedCount());
    bRunMap = !bFDone && c.isBelowCapacity();
}

if (bFDone) {
    f.done(null, results);
} else if (bRunMap) {
    RunMap(items,m,results,c,s,f);
}