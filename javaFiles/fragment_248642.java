package net.pms.plugin.webservice;

import javax.xml.ws.Endpoint;

import org.apache.log4j.Logger;

public abstract class ServiceBase {
    private static final Logger log = Logger.getLogger(ServiceBase.class);
    protected boolean isInitialized;

    /**
     * the published endpoint
     */
    private Endpoint endpoint = null;

    /**
     * 
     * Start to listen for remote requests
     * 
     * @param host ip or host name
     * @param port port to use
     * @param path name of the web service
     */
    public void bind(String host, int port, String path) {
        String endpointURL = "http://" + host + ":" + port + "/" + path;
        try {
            endpoint = Endpoint.publish(endpointURL, this);
            isInitialized = true;
            log.info("Sucessfully bound enpoint: " + endpointURL);
        } catch (Exception e) {
            log.error("Failed to bind enpoint: " + endpointURL, e);
        }
    }

    /**
     * Stop the webservice
     */
    public void shutdown() {
        log.info("Shut down " + getClass().getName());
        if (endpoint != null)
            endpoint.stop();
        endpoint = null;
    }

}