public void hovered() {
      final Component node = node currently hovered over; // node is the component
// that is causing the task to be scheduled
      executor.schedule(new Runnable() {
        public void run() {
          // see if the node that the mouse is over now is the same node it was over 2 seconds ago
          if (getComponentUnderMouse() == node) {
            expand(node); // do this on the EDT
          } else {
            // do nothing because we are over some other node
          }
        }
      }, 2, TimeUnit.SECONDS);
    }