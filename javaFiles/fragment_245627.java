setX(Long: value){ 
    if(x != value){
        x = value
        handler.removeCallbacks(r);
        //run immediately
        handler.post(r);
    }
}

getX(){ return x };