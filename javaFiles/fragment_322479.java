StatelessSession session1, session2, session3, session4;
for (int i=0; i<MAX_ATTEMPTS;i++) {
    try {
        session1 = tryGetSessionOrBoooooom();
    } catch(TimeoutException ex) {
        continue;
    }
    try {
        session2 = tryGetSessionOrBoooooom();
    } catch(TimeoutException ex) {
        session1.close();
        continue;
    }
    try {
        session3 = tryGetSessionOrBoooooom();
    } catch(TimeoutException ex) {
        session2.close();
        session1.close();
        continue;
    }
    try {
        session4 = tryGetSessionOrBoooooom();
    } catch(TimeoutException ex) {
        session3.close();
        session2.close();
        session1.close();
        continue;
    }
}