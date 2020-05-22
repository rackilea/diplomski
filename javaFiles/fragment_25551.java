public String getMensaje() {
    return mensaje;
}

public void setMensaje(String mensaje) {
    String old = this.mensaje;
    this.mensaje = mensaje;
    changeSupport.firePropertyChange("mensaje", old, this.mensaje);
}