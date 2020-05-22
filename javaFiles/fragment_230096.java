List<ProductDiscoveryConf> productDiscoveryConfsShared = new ArrayList<ProductDiscoveryConf>();
    for (String projectKey : projectKeys){
    //productDiscoveryConfs is a list
         productDiscoveryConfs.addAll(productDiscoveryConfService.getAllSharedDiscovery(projectKey));
         productDiscoveryConfsShared.addAll(productDiscoveryConfs);
       }