// if there are no permits available, go to else...
    if (semaphoreForMaxConnectionsAllowed.availablePermits() > 0) {
        handleClientConnectionRequest(newServerSocketForClientConnection, semaphoreForMaxConnectionsAllowed);
    } else {
        // BlockingQueue.offer() puts this connection immediately back into the queue,
        // then the method exits
        if (queuedSockets.offer(newServerSocketForClientConnection)) {
            System.out.println("connectionRequest queued because no more space on server. QueuedSocketList size : " + queuedSockets.size());
        }else{
            System.out.println("No space available for client connections. Can not be queued too.");
        }

    }