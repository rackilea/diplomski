void consomebuffer(String inicio, String fim) {
  synchronized (myMonitor)
  {
    if (posicao < Consumidor.tamanho_buffer ) {
        int identificador;
        identificador=buffer[posicao].getIdentificador()[0];
        System.out.println("Thread: "+Thread.currentThread()+" Pedido: "+identificador+" Inicio: "+inicio+" Fim: "+fim+" posicao "+posicao);
        posicao++;
    }
  }
}