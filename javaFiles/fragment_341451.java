booean isFound=false;
for(ABC a : abc){
    for(String id : a.matIDs()){
        if(ids.contains(id)){
            isFound=true;
            break;
        }
    }
    if(isFound)
        break;
}
if(isFound)
    LOG.info("ID found:::");
else
    LOG.info("ID NOT found:::");