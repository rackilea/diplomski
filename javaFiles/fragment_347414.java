package com.tools;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "servers")
public class Servers {

    private List<Server> servers;

    public List<Server> getServers() {
        return servers;
    }

    @XmlElement(name = "server")
    public void setServers(List<Server> servers) {
        this.servers = servers;
    }

    @Override
    public String toString() {
        return servers.toString();
    }

}