ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setUncaughtExceptionHandler((thread, throwable) -> throwable.printStackTrace())
                .setNameFormat("my-server-thread")
                .build();

        ExecutorService service = Executors.newSingleThreadScheduledExecutor(threadFactory);

        service.submit(() -> {
            while(true) {
                try (ServerSocket serverSocket = new ServerSocket(port)) {
                    try (Socket socket = serverSocket.accept()) {
                        try (InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
                             BufferedReader br = new BufferedReader(streamReader)) {
                            String line;

                            while ((line = br.readLine()) != null) {
                                // your other code in here
                            }
                        }
                    }
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        });