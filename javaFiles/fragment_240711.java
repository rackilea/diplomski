public void añadirNuevo(Procesos procesosArray){
    for(int i=0;i<procesosArray.size();i++){
        Object nuevo[]= {procesosArray.obtener(i).getNombre(),procesosArray.obtener(i).getTam()};
        nuevoTbl.addRow(nuevo);

    try {
        Thread.sleep(1000); // 1 second.
    } catch(InterruptedException ex) {
        Thread.currentThread().interrupt();
    }
 }
}