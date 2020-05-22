//    you can find this code to get some ResourcePool infomation 

          ComputeResource cresource = (ComputeResource) host.getParent();
                    ResourcePool[] resourcepools = cresource.getResourcePool().getResourcePools();


   // if you find a way to search one vm .so  you can write below code. 
    ServiceInstance si = null;
    si = new ServiceInstance(new URL(
                            "https://"+hostVal+"/sdk"), usernameVal,
                            passwordVal, true);
    VirtualMachine vm = (VirtualMachine) new InventoryNavigator(
                                    si.getRootFolder()).searchManagedEntity(
                                    "VirtualMachine", VM_NAME);