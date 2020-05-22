for (Object[] filaRad : listaRad) { //for DB rows
    for (int i = 0; i < filaRad.length; i++) { //for DB columns within a row
        if (filaRad[i] != null) {
            lvRad.getItems().add(filaRad[i].toString());
        }
    }
}