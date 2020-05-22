number = r.nextInt(song.size());
boolean done = false;
int counter = 0;
while(!done){
    for(int i = 0; i < songNums.size(); i++){
        if(number == songNums.get(i).intValue()) {number = r.nextInt(song.size()); counter++;}
    }
    if(counter == 0) done = true;
    else done = false;
}