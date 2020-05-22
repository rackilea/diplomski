public Dato(String nombre, float limiteInferior, float limiteSuperior) {
    //Validar que el limite superior no sea menor o igual al inferior
    if (limiteInferior >= limiteSuperior) {
        throw new IllegalArgumentException("Invalid range!");
    }
    this.nombre = nombre;
    this.limiteInferior = limiteInferior;
    this.limiteSuperior = limiteSuperior;
}