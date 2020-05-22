package com.tools;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "server")
public class Server {

    private String servername;
    private String ipaddress;
    private int port;

    public Server() {
    }

    public Server(String servername, String ipaddress, int port) {
        super();
        this.servername = servername;
        this.ipaddress = ipaddress;
        this.port = port;
    }

    @XmlElement
    public String getServerName() {
        return servername;
    }

    public void setServerName(String servername) {
        this.servername = servername;
    }

    @XmlElement
    public String getIpAddress() {
        return ipaddress;
    }

    public void setIpAddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    @XmlElement
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return servername + " " + ipaddress + " " + port;
    }
}