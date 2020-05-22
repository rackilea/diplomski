Receiver rcvr = MidiSystem.getReceiver();  /* or device.getReceiver() */

  ShortMessage myMsg = new ShortMessage();
  myMsg.setMessage(ShortMessage.NOTE_ON, 0, 60, 93);
  long timeStamp = -1;
  rcvr.send(myMsg, timeStamp);