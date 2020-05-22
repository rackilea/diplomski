private AtomicReference<Thing> currentThing = new AtomicReference<Thing>();

 public Thing getThing() {
      while (true) {
          Thing result = currentThing.get();
          if (result != null)
              return result;
          result = buildThing();
          if (currentThing.compareAndSet(null, result);
              return result;
      }
 }

 private Thing buildThing() {
      // whatever, only important thing is that this creates
      // a new and valid instance of Thing
 }

 public void refresh() {
      Thing freshThing = buildThing();
      currentThing.set(freshThing);
 }