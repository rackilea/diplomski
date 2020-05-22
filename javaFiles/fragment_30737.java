// this is not final so it might reference different objects
Boolean isOn;
...
synchronized (isOn) {
   if (isOn) {
      // this changes the synchronized object isOn to another object
      // so another thread can then enter the synchronized with this thread
      isOn = false;