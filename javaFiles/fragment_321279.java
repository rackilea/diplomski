private IntWritable Medicion = new IntWritable();
private Text Fecha = new Text();
private Text Hora = new Text();

public void readFields(DataInput in) {
    Medicion.readFields(in);
    Fecha.readFields(in);
    Hora.readFields(in);
}