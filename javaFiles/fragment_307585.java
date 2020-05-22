public MessageBox(String displaymsg[], int mins[], int secs[]) {
  super("Step Message");
  setResizable(true);

  messages = new CL1[displaymsg.length];

  for (int i = 0; i < messages.length; i++) {
     messages[i] = new CL1(displaymsg[i], mins[i], secs[i], this);
  }
}