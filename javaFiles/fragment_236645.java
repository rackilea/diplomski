@ModelAttribute("estados")
public List<String> obtenerEstados(){
    logger.debug("buscando todos los estados");

    int cantidadEstados = this.estadoBo.obtenerEstados().size();        
    ArrayList<String> estadoLista = new ArrayList<String>();

    for (int i = 0; i < cantidadEstados; i++) {
        estadoLista.add(this.estadoBo.obtenerEstados().get(i).getNombreEstado());           
    }               
    return estadoLista;             
}