public static void incrementKillcount() {   
        enumMap.put(getId(), killcount++); 
        if(killcount==10){
            //resetting the static killcount value once it reaches 10
            killcount=0;
        }