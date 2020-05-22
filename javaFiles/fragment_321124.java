if (tgbutton.isChecked()){
  mBytes[0] = (byte) (0);
  sendData(mBytes);
  connectSocket("192.168.0.100");
}
else {
  mBytes[0] = (byte) (1);   //Your code actually was mBytes[1] = (byte)(1); which is invalid since you declared mBytes as an array with size 1 only.
  sendData(mBytes);
  connectSocket("192.168.0.100");
}