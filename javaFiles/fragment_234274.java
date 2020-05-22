IWorkItem workItem = workItemClient.findWorkItemById(id, IWorkItem.FULL_PROFILE, monitor);
    System.out.println("Last modified date: "+workItem.modified()+"\n");

    IItemManager itm = teamRepository.itemManager(); 
    List history = itm.fetchAllStateHandles((IAuditableHandle) workItem.getStateHandle(), monitor);
    System.out.println("Record history details:-");
    for(int i = history.size() -1; i >= 0; i--){
        IAuditableHandle audit = (IAuditableHandle) history.get(i);
        IWorkItem workItemPrevious = (IWorkItem) teamRepository.itemManager().fetchCompleteState(audit,null);
        Date recordModifiedDate = workItemPrevious.modified();
        System.out.println("Record modification date: "+recordModifiedDate);
    }