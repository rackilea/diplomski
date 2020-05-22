public class Main {
static Voitleja kangelane;
            public static void main(String[] args) {
                    String nimi = JOptionPane.showInputDialog("Sisestage võitleja nimi");
                    kangelane = new Voitleja(nimi, 55, 12);
            }
    }