class Gallina {
    private int gatoIndex = 0;

    private Gato[] gatos;

    public Gallina(int gatosLength) {
        gatos = new Gato[gatosLength];
    }

    public void addGato(boolean state, String name, String type, int value) {
        if (gatoIndex > gatos.length) {
            // an exception probably or resize array
        }
        gatos[gatoIndex] = new Gato(state, name, type, value);
        gatoIndex += 1;
    }
}

class Test {
    public static void main(String[] args) {
        Gallina gallina = new Gallina(10);

        gallina.addGato(true, "ABC", "Fluffy", 10);
    }
}