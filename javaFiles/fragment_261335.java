Socket mSocket = new Socket(PRINTER_IP, PRINTER_PORT);
OutputStream mPrinter = mSocket.getOutputStream();
mPrinter.write(0x1B);
mPrinter.write(0x70);
mPrinter.write(0);              
mPrinter.write(200);  // t1 
mPrinter.write(255);  // t2