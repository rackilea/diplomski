public void add(InetSocketAddress nodeAddress) {
    if(mconn instanceof ExtMemcachedConnection) {
      ((ExtMemcachedConnection)mconn).add(nodeAddress);  
    }
  }

  public boolean remove(MemcachedNode node) {
    if(mconn instanceof ExtMemcachedConnection) {
      ((ExtMemcachedConnection)mconn).remove(nodeAddress);
    }
  }