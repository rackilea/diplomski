public void guardarPosicion(char input){
    int i = palabra.indexOf(input);
    while(i >= 0) {
        posiciones.add(i);
        i = palabra.indexOf(input, i+1);
    }
}