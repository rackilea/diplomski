//main thread...
        while (shouldContinue) {
            Socket newServerSocketForClientConnection = null;
            // poll immediately gets the same request that was 
            // removed in the previous iteration
            newServerSocketForClientConnection = queuedSockets.poll();

            // Once something is in the queue, this condition will
            // never be met, so no new incoming connections
            // can be accepted
            if (newServerSocketForClientConnection == null) {
                ...
            } else {
                // process the same request again, forever, or until
                // a connection is freed up. Meanwhile, all other
                // incoming requests are being ignored.
                System.out.println("Picking queued socket..");
                processConnection(newServerSocketForClientConnection);
            }
        }