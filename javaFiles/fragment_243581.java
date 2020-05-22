private Response resp1, resp2, resp3;

protected void doRequests() {
    Thread thread1 = new Thread() {
        public void run() {
            resp1= Server.request(a);           
        }
    };
    Thread thread2 = new Thread() {
        public void run() {
            resp1= Server.request(a);           
        }
    };
    Thread thread3 = new Thread() {
        public void run() {
            resp1= Server.request(a);           
        }
    };

    thread1.start();
    thread2.start();
    thread3.start();

    try { thread1.join(); } catch(InterruptedException e) { }
    try { thread2.join(); } catch(InterruptedException e) { }
    try { thread3.join(); } catch(InterruptedException e) { }
}