private OnTaskCompleted listener;
private int id;

public FichaProducto(String codigoBuscar, String currentUser, String ip, 
    String port, OnTaskCompleted listener, int id) {
    setCodigoBuscar(codigoBuscar);
    setCurrentUser(currentUser);
    setIp(ip);
    setPort(port);
    this.listener = listener;
    this.id = id
}

@Override
protected void onPostExecute(String respuesta){
    setRespuesta(respuesta);
    //Here it'll read the xml received and will set the variables
    if (listener != null){
        listener.onTaskCompleted(id);
    }
}