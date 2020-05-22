Configuration config = ManagementConfiguration.configure(
          new URI("https://management.core.windows.net), 
          subscriptionId,
          keyStoreLocation, // the file path to the JKS
          keyStorePassword, // the password for the JKS
          KeyStoreType.jks // flags that I'm using a JKS keystore
        );