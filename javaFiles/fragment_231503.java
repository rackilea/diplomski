int numItems = 42; // whatever your number of list items is
VtxRtVciItem.ByReference[] vtxRtVciItemPointerArray = 
    (VtxRtVciItem.ByReference[]) new VtxRtVciItem.ByReference().toArray(numItems);
VtxRtVciItemList vtxRtVciItemList = new VtxRtVciItemList();
vtxRtVciItemList.uiNumVCIItems = numItems;
vtxRtVciItemList.pVCIItems = vtxRtVciItemPointerArray[0];