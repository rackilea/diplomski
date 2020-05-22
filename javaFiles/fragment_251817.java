RevCommit begin = getBeginCommit();
RevCommit end = getEndCommit();

try (RevWalk rw = new RevWalk(getRepository())) {
    rw.markStart(rw.lookupCommit(begin));
    rw.markUninteresting(rw.lookupCommit(end));
    for (RevCommit curr; (curr = rw.next()) != null;)
        System.out.println("Inspecting entry: " + curr.getShortMessage());
}