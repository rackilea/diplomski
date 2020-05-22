package com.tools;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class ToolConfiguration {
    public static void main(String args[])
    {
        String configFileName = "/config.xml";
        File configFile = new File(ToolConfiguration.class.getResource(configFileName).getFile());
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Servers.class);
            // Read XML
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Servers servers = (Servers) unmarshaller.unmarshal(configFile);

            Server server = new Server("abv", "1.9.3.5", 8080);

            List<Server> serversList = servers.getServers();
            serversList.add(server);

            servers.setServers(serversList);

            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(servers, configFile);

            /*List<Server> serversList = servers.getServers();
            for (Server server : serversList) {
                System.out.println(server.toString());
            }*/

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}