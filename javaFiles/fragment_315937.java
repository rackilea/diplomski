// in an onUpdate method

onUpdate(float secondsElapsed){

if(touched){
if(seconds > 2){
doSomething();
touched = false;
seconds = 0;
} else{
seconds += secondsElapsed;
}
}

}