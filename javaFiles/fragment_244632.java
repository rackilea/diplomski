//main thread...
        while (shouldContinue) {
            Socket newServerSocketForClientConnection = null;
            // poll for a pending connection in the queue
            newServerSocketForClientConnection = queuedSockets.poll();

            // if a pending connection exists, go to else...
            if (newServerSocketForClientConnection == null) {
                ...
            } else {
                // queue has a socket request pending, so we process the request...
                System.out.println("Picking queued socket..");
                processConnection(newServerSocketForClientConnection);
            }
        }