public static Cuadrante obtenerCuadrante (Punto p){
    Cuadrante res = Cuadrante.EJE;
    if (p.getX()>0 && p.getY()>0){
        res = Cuadrante.PRIMER_CUADRANTE;
    } else {
        if (p.getX() > 0 && p.getY() < 0) {
            res = Cuadrante.CUARTO_CUADRANTE;
        } else {  
            if (p.getX() < 0 && p.getY() > 0) {
                res = Cuadrante.SEGUNDO_CUADRANTE;
            } else {
                if (p.getX() < 0 && p.getY() < 0) {
                    res = Cuadrante.TERCER_CUADRANTE;
                } else {
                    res = Cuadrante.EJE;
                }
            }
        }
    }
    return res;
}