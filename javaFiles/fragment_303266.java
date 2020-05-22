if (!this.listaEspera.isEmpty()){               //Si hay alguien en la lista de espera...
    for(int i=0;i<this.numMesas;i++){           //Recorremos todas las mesas del casino
        if(this.misMesas.get(i).nJugadores<5){  //Si hay alguna silla vacia en esa mesa...
            this.misMesas.get(i).sentarJugador(this.listaEspera.get(0));    //Sentamos al jugador que mas lleva esperando
            this.totalJugadores++;              //Incrementamos el numero de jugadores que han pasado por el casino
            this.listaEspera.get(0).tiempoEmpieza = reloj.getTiempo();  //Establecemos el tiempo en el que se sienta el jugador al momento actual
            this.totalEsperado = this.totalEsperado + (this.listaEspera.get(0).tiempoEmpieza - this.listaEspera.get(0).tiempoEntrada);  //Sumamos el tiempo que ha estado esperando el jugador al tiempo de espera total
            this.listaEspera.remove(0);         //Lo quitamos de la lista de espera
        }
    }
}