public void mostrar(int a) {
    for (Celula i = primeiro.prox; i != null; i = i.prox) {
        if (i.elemento > a) {
            if(this.pesquisar(a) == false){
                System.out.println(a+","+i.elemento +","+i.peso);       
            }
        }
    }
}