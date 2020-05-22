boolean played = false;
while (true) {
  String sound = null;
  if (controller.isButtonPressed(1)) 
    sound = "hiHat.wav";
  if (controller.isButtonPressed(2)) 
    sound = "crash.wav";
  if (sound != null) {
    if (!played) {
      drum.playSound(sound);
      played = true;
    }
  } else {
    played = false;
  }
  Thread.sleep(50);
}