void update(){
    try{
        for(int i = 0;i<entities.length;i++){               
            GameEntity entity = entities[i];                
            synchrnonized(entity){
                entity.updatePosition();
            }               
        }
    }catch(ArrayIndexOutOfBoundsException aioob){
        if(tryAgain){
            update();
        } else {
            return;
        }
    }
}