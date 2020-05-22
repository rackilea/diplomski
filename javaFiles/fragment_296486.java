public List<ServiceProvider> getProvidersForService(String serviceName) throws TException {
    ServiceProvider serviceProvider = new ServiceProvider();
    List<ServiceProvider> result = new ArrayList<>();                       
    for(Map.Entry<Node, Integer> pair : nodePorts.entrySet()) {
            //problems start here               
        List<String> nodeService = pair.getKey().serviceList;
        for(String s : nodeService) {
            if(s.contains(serviceName))
               // **update service provide before adding here by putting host/port**   
                result.add(serviceProvider);
                break;
            }
        }
    return result;
}