InfoObj getInfo() {
    RunnableFuture<InfoObj> rf = new FutureTask<>(() -> getInfoObjOnEDT());
    SwingUtilities.invokeLater(rf);
    try {
        return rf.get();
    } catch (InterruptedException|ExecutionException ex) {
        ex.printStackTrace(); // really, you can do better than this
    }
}