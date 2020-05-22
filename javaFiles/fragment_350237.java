// in main 
List<LockAlgorithm> algos = Arrays.asList(new BFSLockAlgorithm());
Lock l = new Lock("data");
for (LockAlgorithm a : algos) {
    if (l.isLocked()) {
        if (a.break(l)) System.out.print("success");
    } 
}
if (l.isLocked()) {
    System.out.print("failed"); 
}