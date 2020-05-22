AtomicBoolean dirty = new AtomicBoolean(false);
while (running) {
        // extract some information
        ...

        if (!dirty.getAndSet(true)) {            
          SwingUtilities.invokeLater(new Runnable() {
              public void run() {
                if (dirty.getAndSet(false)) {
                   // use information to update a graph
                }
              }
          });
        }

        // sleep some seconds
        ...
    }