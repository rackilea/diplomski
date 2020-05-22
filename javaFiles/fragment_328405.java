@MTOM
@WebService(targetNamespace="http://soap.services.website.com/", 
        endpointInterface="com.armorize.web.services.ServiceInterface")
public interface ServiceInterface

  int uploadData(@XmlMimeType("application/octet-stream") DataHandler code) ;