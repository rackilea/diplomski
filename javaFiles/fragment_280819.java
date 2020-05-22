public boolean ifor(int val, int... comparisons){
    for(int o : comparisons){
        if(val == o) return true;
    }
    return false;
}