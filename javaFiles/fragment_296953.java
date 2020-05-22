for(Cloudlet cloudlet: getCloudletSubmittedList()){
        if(!finishedCloudlets.contains(cloudlet) && cloudlet.isFinished()){
        Vm vm = getVmsCreatedList().get(cloudlet.getVmId()-1);                        
        vm.setCurrentAllocatedRam(vm.getCurrentAllocatedRam() - (int)(cloudlet.getUtilizationOfRam(CloudSim.clock())*100));
        vm.updateVmProcessing(CloudSim.clock(), null);
        finishedCloudlets.add(cloudlet);
    }
}