public int getDeep(Nodo n){
    if(n == null)
        return 0;

    int dd = getDeep(n.getHijoDer() );
    int di = getDeep(n.getHijoIzq() );

    return 1 + (dd > di ? dd : di);
}