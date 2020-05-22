List<Client> unflatten(List<IncomingFlatItem> flatItems) {
    return flatItems.parallelStream()
            .map(IncomingFlatItem::getClient)
            .collect(Collectors.groupingByConcurrent(client -> client))
            .entrySet().parallelStream()
            .map(kvp -> kvp.getValue()
                    .stream()
                    .reduce(new Client(), 
                            (client1, client2) -> {
                                    client1.getReports()
                                            .forEach(client2::addReport);
                                    client1.getEmailAddresses()
                                            .forEach(client2::addEmail);
                                    return client2;
                    }))
            .collect(Collectors.toList());
}