public static void main(String[] args) {

try {
    // Url con la foto
    URL url = new URL(
            "http://plazavea.com.pe/RepositorioAPS/0/0/cat/37/FOLLETO23_CLIENTE10.jpg");

    // establecemos user-agent del sistema
    System.setProperty("http.agent", "Mozilla/5.0 (Windows NT 5.1; rv:19.0) Gecko/20100101 Firefox/19.0");

    // establecemos conexion
    URLConnection urlCon = url.openConnection();

    // Sacamos por pantalla el tipo de fichero
    System.out.println(urlCon.getContentType());

    // Se obtiene el inputStream de la foto web y se abre el fichero
    // local.
    InputStream is = urlCon.getInputStream();
    FileOutputStream fos = new FileOutputStream("d:/foto.jpg");

    // Lectura de la foto de la web y escritura en fichero local
    byte[] array = new byte[1000]; // buffer temporal de lectura.
    int leido = is.read(array);
    while (leido > 0) {
        fos.write(array, 0, leido);
        leido = is.read(array);
    }

    // cierre de conexion y fichero.
    is.close();
    fos.close();
} catch (Exception e) {
    e.printStackTrace();
}

}