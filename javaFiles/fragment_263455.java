package example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class LogLvlByMarkerMain {
    private static final Logger log = LogManager.getLogger();
    private static final Marker DEVICE1 = MarkerManager.getMarker("DEVICE1");
    private static final Marker DEVICE2 = MarkerManager.getMarker("DEVICE2");

    public static void main(String[] args) {
        log.info(DEVICE1, "The first device got some input");
        log.info(DEVICE2, "The second device now has input");
    }
}