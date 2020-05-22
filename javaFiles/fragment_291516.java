public static void main(String[] args) {
    int lewy = 0;
    int prawy = 10;

    licz("Text",lewy, prawy);
}

static public void licz(String wiersz, int lewy, int prawy) {
    double wynik = 0.0;
    List<Double> listaX = new ArrayList();
    for (int i = lewy; i <= prawy; i++) {
        listaX.add((double) i);
    }
    System.out.println(listaX);
}