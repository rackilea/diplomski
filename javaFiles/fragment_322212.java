public class YIFY {
    private static ObservableList<Pelicula> resultados = FXCollections.observableArrayList();

    public static void setResultados(List<Pelicula> resultados) {
        YIFY.resultados.setAll(resultados);
    }
}