import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Personas {
    private StringProperty nombre = new SimpleStringProperty();
    private StringProperty apellido = new SimpleStringProperty();

    public StringProperty nombreProperty() {return nombre;};
    public StringProperty apellidoProperty() {return apellido;};

    public Personas(String nombre, String apellido) {
        this.nombre.set(nombre);
        this.apellido.set(apellido);
    }

    public String getNombre() {return nombre.get();}
    public String getApellido() {return apellido.get();}
}