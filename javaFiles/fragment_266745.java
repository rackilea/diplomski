private void imprimeRamaLargaRec(Nodo n) {
    if (n != null) {
        int dd = getDeep(n.getHijoDer() );//deep for the right child
        int di = getDeep(n.getHijoIzq() );//deep for the left child

        if(dd > di){
            imprimeRamaLargaRec(n.getHijoDer() );
        }else{
            imprimeRamaLargaRec(n.getHijoIzq() );
        }
        System.out.println(n.getId());  
    }
}