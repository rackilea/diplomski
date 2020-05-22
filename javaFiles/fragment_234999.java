IFlowTable flowTable = lv2Stream.getFlowTable().getWorkingCopy();
        flowTable.addDeliverFlow(lv1Stream.getResolvedWorkspace(), repo.getId(),
            repo.getRepositoryURI(), null, lv1Stream.getDescription());
        IFlowEntry flowNode =
            flowTable.getDeliverFlow(lv1Stream.getResolvedWorkspace());
        flowTable.setDefault(flowNode);
        flowTable.setCurrent(flowNode);
        lv2Stream.setFlowTable(flowTable, null);