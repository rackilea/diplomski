rootPojo.getClients()
    .stream()
    .collect(Collectors.groupingBy(ClientInfo::getName,
            Collectors.summingInt(ClientInfo::getMember)))
    .forEach((k,v) -> {
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.setName(k);
        clientInfo.setGroup("all");
        clientInfo.setMember(v);
        rootPojo.getClients().add(clientInfo);
    });
System.out.println(rootPojo.toString());