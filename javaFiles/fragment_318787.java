function warnOnChange(){
    decision = true;
    if(tabDirty){
        decision = confirm('Leave?');
        if(decision){
            resetTab();
        }
    }
    return decision;
}