public void turnOn() {
   this.on = true;
}

public void channelUp() {
   if (on) {
      if (channel == maxChannel) {
         channel = 1;
      }
      else {
         channel++;
      }
   }
}

public void volumeDown() {
   if (on && volume > 0) {
      volume--;
   }
}