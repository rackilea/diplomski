String uri = "https://management.core.windows.net/";
String subscriptionId = "<subscription_id>";
String keyStoreLocation = "KeyStore.jks";
String keyStorePassword = "<password>";

Configuration config = ManagementConfiguration.configure(
       new URI(uri), 
       subscriptionId,
       keyStoreLocation, // the file path to the JKS
       keyStorePassword, // the password for the JKS
       KeyStoreType.jks // flags that I'm using a JKS keystore
    ); 
ComputeManagementClient computeManagementClient = ComputeManagementService.create(config);
VirtualMachineOperations virtualMachinesOperations = computeManagementClient.getVirtualMachinesOperations();
virtualMachinesOperations.restart("petercore", "petercore", "petercore");