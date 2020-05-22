boolean isFirst = true;
while(itr.hasNext()) {
    if(isFirst) {
        isFirst = false;
    } else {
        outScopeActiveRegionCode+=",";
    }
    outScopeActiveRegionCode+=itr.next();
}