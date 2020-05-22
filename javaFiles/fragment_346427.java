final ConcurrentLinkedDeque<String> queue = new ConcurrentLinkedDeque<>();

 while(running.get()){
    Socket socket = listen.accept();
    pool.submit(() -> {

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
            while(socket.isConnected()){
                queue.push(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    });
    pool.submit(() -> {
        try(OutputStream os = socket.getOutputStream()){
            if(!queue.isEmpty()){
                 os.write(queue.pop().getBytes());
            }
         } catch (IOException e) {
            e.printStackTrace();
         }
    });
 }