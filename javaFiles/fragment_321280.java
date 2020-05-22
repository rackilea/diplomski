public void readFields(DataInput in) {
    Medicion = new Text();
    Medicion.readFields(in);

    Fecha = new Text();
    Fecha.readFields(in);

    Hora = new Text();
    Hora.readFields(in);
}