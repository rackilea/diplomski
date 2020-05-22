public double DMSaDecimal(int grados, int minutos, double segundos, String direccion) {

    double decimal = Math.signum(grados) * (Math.abs(grados) + (minutos / 60.0) + (segundos / 3600.0));

    //reverse for south or west coordinates; north is assumed
    if (direccion.equals("S") || direccion.equals("W")) {
        decimal *= -1;
    }

    return decimal;
}

public String[] SeparararDMS(String coordenada, int type) {

    String grados = null;
    String minutos = null;
    String segundos = null;
    String direccion = null;


    switch (type) {
        case 1: // latitude
            grados = coordenada.substring(0, 2);
            minutos = coordenada.substring(2, 4);
            segundos = coordenada.substring(5, coordenada.length() - 1);
            break;
        case 2: // longitude
            grados = coordenada.substring(0, 3);
            minutos = coordenada.substring(3, 5);
            segundos = coordenada.substring(6, coordenada.length() - 1);
            break;
        default:

    }

    double sec = 0;
    try {
        sec = Double.parseDouble("0."+segundos);
    }catch(Exception e) {

    }


    sec = (sec * 60);
    direccion = coordenada.substring(coordenada.length() - 1);

    String[] data = {grados, minutos, sec + "", direccion};
    return data;
}