function sampleRecursion(a){
    if(isTerminalCase) {
        return true;
    }
    else {
       a = modify(a);
       return sampleRecursion(a);
    }
}