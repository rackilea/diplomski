stopPort = 1234
stopKey = 'stopKey'
// gradle is luser. Full story (and code copied from): https://issues.gradle.org/browse/GRADLE-2263
import org.gradle.api.plugins.jetty.internal.Monitor
[jettyRun, jettyRunWar]*.doLast {
    /**
     * THIS IS A WORKAROUND! THE CURRENT VERSION OF THIS TASK DOESN'T START A WATCHER IN DAEMON MODE
     *
     * If starting the monitor fails, it may be because the jetty task was updated to fix this issue
     * When that happens, we shouldn't need the custom task any more
     *
     * Copied From: AbstractJettyRunTask
     */
    if (getStopPort() != null && getStopPort() > 0 && getStopKey() != null) {
        Monitor monitor = new Monitor(getStopPort(), getStopKey(), server.getProxiedObject());
        monitor.start();
    }
}