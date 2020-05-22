enum ExecutionType {
    ATYPE,
    BTYPE
}

public static void requestedFunction(ExecutionType eType){
    for(int i=0; i<amount; i++){
        if (eType==ExecutionType.ATYPE)
            aField = 5;
        else if (eType ==ExecutionType.BTYPE)
            bField = 5; 
    }
}

requestedFunction(ExecutionType.ATYPE);
requestedFunction(ExecutionType.BTYPE);