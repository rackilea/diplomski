public void addConfig(SolManConfig solManConfig){
    String tenantId = userProvider.get();
    solManConfig.setTenant(getCurrentTenant());
    Tenant tenant = tentantRepository.findOne(tenantId);
    dbRepository.save(solManConfig);
}