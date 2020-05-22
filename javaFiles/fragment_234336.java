private Data getStudentDataEqual(PassIndLinkReq passIndLinkReq, List<Data> dataList, Long val){        
    for (T data:dataList){
        if (data.getPassIndLinkId().intValue()==passIndLinkReq.getId().intValue()) {
            switch (passIndLinkReq.getDatatype().intValue()) {
                case 0:  
                case 1: 
                    return data;
                case 7: 
                    if (data.getClassItemTreeId().equals(val)){
                        return data;
                    }
                    break;
                ...
                }
            }        
        }                        
    return new Data();
}