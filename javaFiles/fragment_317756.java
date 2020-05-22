SlaContract sumContract = slaContractList.stream()
    .reduce(new SlaContract(0, 0.0, 0.0), (sla1, sla2) -> {
         return new SlaContract(sla1.getNumberOfCPUs() + sla2.getNumberOfCPUs(), sla1.getworkBandwith() + sla2.getworkBandwith(), sla1.getMemory() + sla2.getMemory());
    });

Double wnetwork = sumContract.getworkBandwith();
Double wMem = sumContract.getMemory();
Integer wCPU = sumContract.getNumberOfCPUs();