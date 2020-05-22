// not accessible from outside
private Dato(String nombre, float limiteInferior, float limiteSuperior) {
    assert limiteInferior < limiteSuperior : "lower limit must be lower";
    this.nombre = nombre;
    this.limiteInferior = limiteInferior;
    this.limiteSuperior = limiteSuperior;
}

public static Dato create(String nombre, float limiteInferior, float limiteSuperior) {
    if (limiteInferior >= limiteSuperior) {
        return null;
    }
    // params are valid, let's create this thing
    return new Dato(nombre, limiteInferior, limiteSuperior);
}