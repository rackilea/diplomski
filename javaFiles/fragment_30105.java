boolean working = true;
ServerSocket ss = new ServerSocket(9100);
while(working) {
        Socket s = ss.accept();
        MyThread myThread = new MyThread(s);
        myTread.start();
}