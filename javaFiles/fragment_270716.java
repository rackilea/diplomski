import org.apache.jmeter.engine.JMeterEngine;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;
import org.apache.jorphan.logging.LoggingManager;
import org.apache.jorphan.util.HeapDumper;
import org.apache.log.Logger;

import java.io.File;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;


public class JMeterFromExistingJMX {

    private static final Logger log = LoggingManager.getLoggerForClass();

    public static void main(String[] argv) throws Exception {
        // JMeter Engine
        final StandardJMeterEngine jmeter = new StandardJMeterEngine();

        // Initialize Properties, logging, locale, etc.
        JMeterUtils.loadJMeterProperties("/opt/jmeter/bin/jmeter.properties");
        JMeterUtils.setJMeterHome("/opt/jmeter");
        JMeterUtils.initLogging();// you can comment this line out to see extra log messages of i.e. DEBUG level
        JMeterUtils.initLocale();

        // Initialize JMeter SaveService
        SaveService.loadProperties();

        HashTree testPlanTree = SaveService.loadTree(new File("/opt/jmeter/bin/test.jmx"));

        final List<JMeterEngine> engines = new ArrayList<>();
        engines.add(jmeter);

        int port = JMeterUtils.getPropDefault("jmeterengine.nongui.port", 4445); // $NON-NLS-1$
        int maxPort = JMeterUtils.getPropDefault("jmeterengine.nongui.maxport", 4455); // $NON-NLS-1$
        if (port > 1000) {
            final DatagramSocket socket = getSocket(port, maxPort);
            if (socket != null) {
                Thread waiter = new Thread("UDP Listener") {
                    @Override
                    public void run() {
                        waitForSignals(engines, socket);
                    }
                };
                waiter.setDaemon(true);
                waiter.start();
            } else {
                System.out.println("Failed to create UDP port");
            }
        }

        // Run JMeter Test
        jmeter.configure(testPlanTree);
        jmeter.run();
    }

    private static void waitForSignals(final List<JMeterEngine> engines, DatagramSocket socket) {
        byte[] buf = new byte[80];
        System.out.println("Waiting for possible Shutdown/StopTestNow/Heapdump message on port " + socket.getLocalPort());
        DatagramPacket request = new DatagramPacket(buf, buf.length);
        try {
            while (true) {
                socket.receive(request);
                InetAddress address = request.getAddress();
                // Only accept commands from the local host
                if (address.isLoopbackAddress()) {
                    String command = new String(request.getData(), request.getOffset(), request.getLength(), "ASCII");
                    System.out.println("Command: " + command + " received from " + address);
                    log.info("Command: " + command + " received from " + address);
                    switch (command) {
                        case "StopTestNow":
                            for (JMeterEngine engine : engines) {
                                engine.stopTest(true);
                            }
                            break;
                        case "Shutdown":
                            for (JMeterEngine engine : engines) {
                                engine.stopTest(false);
                            }
                            break;
                        case "HeapDump":
                            HeapDumper.dumpHeap();
                            break;
                        default:
                            System.out.println("Command: " + command + " not recognised ");
                            break;
                    }
                }
            }
        } catch (Exception e) {
            log.error("Error", e);
        } finally {
            socket.close();
        }
    }

    private static DatagramSocket getSocket(int udpPort, int udpPortMax) {
        DatagramSocket socket = null;
        int i = udpPort;
        while (i <= udpPortMax) {
            try {
                socket = new DatagramSocket(i);
                break;
            } catch (SocketException e) {
                i++;
            }
        }

        return socket;
    }
}