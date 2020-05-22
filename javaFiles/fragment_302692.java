this.sequencer.addMetaEventListener(new MetaEventListener() {
          public void meta(MetaMessage event) {
              if (event.getType() == 47) {
                  // start new sequence
              }
          }
    });;