public int findMax(){
    // This variable doesn't serve much purpose
    int max = value;
    if(next == null){
        return max;
    }
    else{
        // This if condition simply prevents us from following
        // the else block below but the stuff inside does nothing.
        if(max <= next.findMax()){
           // max is never used again if you are here.
           max = next.value;
        }
        else return max;
    }
    // We now compute findMax() again, leading to serious inefficiency
    return next.findMax();
}