import java.util.HashMap;
import java.util.Map;

public final class Translator {

    private Map<String, String> translation;

    public Translator() {
        translation = new HashMap<>();
        translation.put("Crans Montana", "Crans-Montana");
        translation.put("Soelden", "Sölden");
        translation.put("Val d Isere", "Val d'Isere");
        translation.put("St. Moritz", "Sankt Moritz");
    }

    public String translate(String input) {
        String result = this.translation.get(input);
        return (result != null) ? result : "";
    }

    public static void main(String[] args) {
        Translator t = new Translator();

        System.out.println(t.translate("Soelden")); // prints Sölden
    }
}