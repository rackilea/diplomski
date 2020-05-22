public void registerResourceFactories(ResourceSet resourceSet) 
      {
        super.registerResourceFactories(resourceSet);
        // code added by me

        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("systembehavior", new XMIResourceFactoryImpl());
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("peerbehavior", new XMIResourceFactoryImpl());
       }