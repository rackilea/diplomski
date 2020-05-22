package com.test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class AppJsonTest {

    public static void main(String[] args) {
        List<DataObject> objList = new ArrayList<DataObject>();
        objList.add(new DataObject(1, "Coca Cola", 0.9, 19));
        objList.add(new DataObject(2, "Coca Cola Zero", 0.6, 19));

        // Convert the object to a JSON string
        String json = new Gson().toJson(objList);
        System.out.println(json);

        // Now convert the JSON string back to your java object
        Type type = new TypeToken<List<DataObject>>() {
        }.getType();
        List<DataObject> inpList = new Gson().fromJson(json, type);
        for (int i = 0; i < inpList.size(); i++) {
            DataObject x = inpList.get(i);
            System.out.println(x.toString());
        }
    }
}

class DataObject {
    int idProducto;
    String Nombre;
    Double Precio;
    int Cantidad;

    public DataObject(int idProducto, String nombre, Double precio, int cantidad) {
        this.idProducto = idProducto;
        Nombre = nombre;
        Precio = precio;
        Cantidad = cantidad;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double precio) {
        Precio = precio;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "DataObject [idProducto=" + idProducto + ", Nombre=" + Nombre + ", Precio=" + Precio + ", Cantidad=" + Cantidad + "]";
    }

}