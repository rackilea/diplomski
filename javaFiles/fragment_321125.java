if (tgbutton.isChecked()){
  mBytes[0] = (byte) (0);
}
else {
  mBytes[0] = (byte) (1);
}
sendData(mBytes);
connectSocket("192.168.0.100");