try (Connection conn = getConn()) {
    setConnIsolation(conn);

    // Posted from Thread-1
    singleThread.execute(new Runnable() {

        @Override
        public void run() {

        // Thread-2 accesses conn created on Thread-1
        // use conn here..
    });

   // ....doing some other work....

} catch (Exception e) {
    System.err.println("Error");
}

//Conn is released