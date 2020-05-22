class DatasToreWriteCapabiliti{
  boolean DATASTORE_WRITE = true;

  public disable(){ DATASTORE_WRITE = false;}
  public enable(){ DATASTORE_WRITE = true;}

  public CapabilityStatus status(){
     if(DATASTORE_WRITE == false) return CapabilityStatus.DISABLED;

     CapabilitiesService service = CapabilitiesServiceFactory.getCapabilitiesService();
     return service.getStatus(Capability.DATASTORE_WRITE).getStatus();
  }
}