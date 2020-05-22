AtomicBoolean running = new AtomicBoolean();
    ExecutorService pool = Executors.newFixedThreadPool(10;
    ServerSocket listen = new ServerSocket(11000);
    while(running.get()){
        Socket socket = listen.accept();
        pool.submit(() -> {

            try(InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream()){

               //put I/O logic here


            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }