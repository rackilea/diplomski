private void handleInput() {

    while(true) {
      GameEvent evt = eventQueue.poll();
      if(evt == null)
        break;

      if(evt instanceof KeyGameEvent) {
        processKeyGameEvent((KeyGameEvent)evt);
      }
      else if(evt instanceof TouchGameEvent) {
        processTouchGameEvent((TouchGameEvent)evt);
      }
      // ... etc. for the different types of events.
    }
  }