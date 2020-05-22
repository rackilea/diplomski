import java.util.logging.Logger;
import org.slf4j.bridge.SLF4JBridgeHandler;

SLF4JBridgeHandler.removeHandlersForRootLogger();
SLF4JBridgeHandler.install();
Logger.getLogger("").setLevel(Level.FINEST); // Root logger, for example.