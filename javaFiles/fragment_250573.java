public int count(){
    int ctr = 1;   
    if( this.next() != null ){     
        ctr += this.next().count();  
    }
    return ctr;
}