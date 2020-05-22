import javax.enterprise.inject.Produces;

private List <CDXmlDescriptor> cdsList;
...
@Named("cdsList") 
@Produces 
public List<CDXmlDescriptor> getCdsList {
  return cdsList;
};