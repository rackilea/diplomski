public IaaSService createCloudAndReturnWithIt(int counter, IaasService iaas) 
{
    try 
    { 
      iaas = CloudLoader.loadNodes("C:\\Users\\Tom\\git\\dissect-cf-examp‌les\\PM.xml");
    } 
    catch (IOException | SAXException | ParserConfigurationException e)  
    {
        e.printStackTrace(); 
    } 
    return (counter <= 0) ? iaas : createCloudAndReturnWithIt(--counter, iaas); 
}

public IaaSService createCloudAndReturnWithIt(IaasService iaas) 
{
     return createCloudAndReturnWithIt(2, iaas);
}