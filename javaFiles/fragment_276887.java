protected final OperationFactory opFact;

  /**
   * Construct a memcached connection.
   *
   * @param bufSize the size of the buffer used for reading from the server
   * @param f       the factory that will provide an operation queue
   * @param a       the addresses of the servers to connect to
   * @throws java.io.IOException if a connection attempt fails early
   */
  public ExtendableMemcachedConnection(int bufSize, ConnectionFactory f,
                                       List<InetSocketAddress> a,
                                       Collection<ConnectionObserver> obs,
                                       FailureMode fm, OperationFactory opfactory)
      throws IOException {
    super(bufSize, f, a, obs, fm, opfactory);
    this.opFact = opfactory;
  }

  public void add(InetSocketAddress nodeAddress) throws IOException {
    final List<InetSocketAddress> nodeToAdd = new ArrayList<InetSocketAddress>(1);
    nodeToAdd.add(nodeAddress);
    List<MemcachedNode> newNodesList = createConnections(nodeToAdd);
    newNodesList.addAll(getLocator().getAll());
    getLocator().updateLocator(newNodesList);
  }

  //The node should be obtain from locator to ensure currentNode.equals(node) will return true
  public void remove(MemcachedNode node) throws IOException {
    for(MemcachedNode currentNode : getLocator().getAll()) {
      if(currentNode.equals(node)) {
        Collection<Operation> notCompletedOperations = currentNode.destroyInputQueue();
        if (currentNode.getChannel() != null) {
          currentNode.getChannel().close();
          currentNode.setSk(null);
          if (currentNode.getBytesRemainingToWrite() > 0) {
            getLogger().warn("Shut down with %d bytes remaining to write",
                             currentNode.getBytesRemainingToWrite());
          }
          getLogger().debug("Shut down channel %s", currentNode.getChannel());
        }
        //Unfortunatelly,  redistributeOperations is private so it cannot be used or override. I put copy/paste the implementation
        redistributeOperations(notCompletedOperations);
      }
    }
  }

  protected void redistributeOperations(Collection<Operation> ops) {
    for (Operation op : ops) {
      if (op.isCancelled() || op.isTimedOut()) {
        continue;
      }
      if (op instanceof KeyedOperation) {
        KeyedOperation ko = (KeyedOperation) op;
        int added = 0;
        for (String k : ko.getKeys()) {
          for (Operation newop : opFact.clone(ko)) {
            addOperation(k, newop);
            added++;
          }
        }
        assert added > 0 : "Didn't add any new operations when redistributing";
      } else {
        // Cancel things that don't have definite targets.
        op.cancel();
      }
    }
  }


}