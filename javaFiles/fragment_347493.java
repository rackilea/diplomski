package skilift;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SkiLift implements Runnable{

    private ScheduledExecutorService getOutClientExecutor;

    public SkiLift() {
        getOutClientExecutor = Executors.newScheduledThreadPool(50);
        waitingClientsQueue = new ArrayBlockingQueue<>(1000);
        occupiedSeats = new ArrayList<>();
    }

    private final ArrayList<Client> occupiedSeats; 

    private long usedCapacity;

    private final ArrayBlockingQueue<Client> waitingClientsQueue;

    private final long capacity = 500;

    public void add(Client client) {
        synchronized(waitingClientsQueue) {
            waitingClientsQueue.add(client);
            waitingClientsQueue.notify();
        }

    }


    private synchronized void occupySeat(Client client) {
        occupiedSeats.add(client);
        usedCapacity += client.weight;
    }

    private synchronized void getClientOut(Client client) {
        occupiedSeats.remove(client);
        usedCapacity -= client.weight;

        // notify the waitingClientQueue that the capacity has changed
        synchronized (waitingClientsQueue) {
            waitingClientsQueue.notify();
        }

        client.topReached();
    }


    public void run() {
        while (true) {
            synchronized(waitingClientsQueue) {
                try {

                    if (!waitingClientsQueue.isEmpty()) {
                        Client c = waitingClientsQueue.peek();
                        if (usedCapacity + c.weight <= capacity) {
                            occupySeat(waitingClientsQueue.poll());
                            getOutClientExecutor.schedule(() -> {
                                getClientOut(c);
                            }, 2, TimeUnit.SECONDS);
                        } else {
                            waitingClientsQueue.wait();
                        }
                    } else {
                        waitingClientsQueue.wait();
                    }

                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

}