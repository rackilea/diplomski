public void checkTrolls(){
    for(Iterator<AutomatedSprite> itr = trolls.iterator(); itr.hasNext();){
        AutomatedSpring nextElemnt = itr.next();
        if(youShouldRemoveTheSprite){
            itr.remove();
        }
    }
}