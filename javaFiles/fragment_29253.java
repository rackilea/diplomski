threadHandler = new ThreadPoolExecutor( maxThreads, maxThreads, 1, TimeUnit.MINUTES,
            new ArrayBlockingQueue<Runnable>( maxThreads, true ) );
    while (!serverTerminated) {
        try {
            final Socket connectionSocket = serversocket.accept();
            SocketHandler handler = new SocketHandler( this, connectionSocket );
            threadHandler.submit( handler );
        } catch (IOException e) {
            if (!serverTerminated)
                e.printStackTrace();
        }
    }