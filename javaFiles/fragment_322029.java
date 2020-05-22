for (int j = 0; j < clientes.length; ++j) {
  String nombreFichero = new String();
  for (int i = 0; i < clientes[j].nombre.length && clientes[j].nombre[i] != null; ++i) {
    String nombreCliente = clientes[j].nombre[i].convertirPalabraEnString();
    nombreFichero += (nombreCliente + " ");
  }

  FileWriter writer = new FileWriter(nombreFichero.trim() + ".txt", false);
}