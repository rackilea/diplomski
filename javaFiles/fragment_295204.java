private AType getAtype(boolean needsRefresh, Integer id) {
    synchronized(theMap) {
        if (needsRefresh) {
          theMap.clear();
        }

        if (theMap.size() == 0) {
          // populate the set
        }

        return theMap.get(id);
    }
  }