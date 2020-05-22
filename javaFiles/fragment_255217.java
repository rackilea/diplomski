package net.bounceme.dur.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import net.bounceme.dur.data.Title;

public class ProducerConsumerService implements Executor {

    private static final Logger log = Logger.getLogger(ProducerConsumerService.class.getName());
    private final BlockingQueue<Title> queue = new ArrayBlockingQueue<>(1);
    private Producer producer = null;
    private Consumer consumer = null;
    private Title title = null;

    public void ProducerConsumerService() {
    }

    public Title produce() throws InterruptedException, IOException, ClassNotFoundException {
        producer.produce();
        title = queue.take();
        consumer.consume(title);
        return title;
    }

    public void startService() throws IOException {
        Properties props = PropertiesReader.getProps();
        int portNumber = Integer.parseInt(props.getProperty("port"));
        String host = props.getProperty("server");
        Socket socket = new Socket(host, portNumber);
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        producer = new Producer(queue, objectInputStream);
        consumer = new Consumer(queue, objectOutputStream);
        new Thread((Runnable) producer).start();
        new Thread((Runnable) consumer).start();
        log.info("started...");
    }

    @Override
    public void execute(Runnable command) {
        new Thread(command).start();
    }
}