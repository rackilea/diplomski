class NodeLocker {
    HashSet<Node> lockedNodes = new HashSet();
    protected boolean tryLock(List<Node> nodes) {                   
        for(n: Nodes) {
            if(lockedNodes.contains(n)) return false;
        }
        lockedNodes.addAll(nodes);
        return true;
    }
    public synchronized void lock(Node ... nodes) throws InterruptedException {
        while(!tryLock(Arrays.asList(nodes))) wait();
    }
    public synchronized void unlock(Node ... nodes) {
        lockedNodes.removeAll(Arrays.asList(nodes));
        notify();
    }
}