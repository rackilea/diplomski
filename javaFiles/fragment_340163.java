public class Producer {

  //get a hold of some DAO or other repository of you config
  private ConfigRepository configRepo;

  @Produces
  @Config
  public String produceConfigEntry(InjectionPoint ctx) {
    Key anno = //get value of @Key annotation from the injection point, bean, property...
    String tenantId = ThreadLocalHolder.getTenantId();
    // adjust to your needs
    return configRepo.getConfigValueForTenant(anno.value(), tenantId);
  }
}