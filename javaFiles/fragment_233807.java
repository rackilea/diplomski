try {
        myConnection = com.sforce.soap.partner.Connector.newConnection(PartnerCfg);
        metadataCfg.setSessionId(trgtConnection.getSessionHeader().getSessionId());
        metadataConnection = com.sforce.soap.metadata.Connector.newConnection(metadataCfg);
    } catch (ConnectionException e) {
            System.out.println("An error occured while connecting to the org.");
    }