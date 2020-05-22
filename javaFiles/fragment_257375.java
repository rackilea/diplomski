import java.util.*;
class Measurement {
    public static final Map<Integer,String> prefixes;
    static {
        Map<Integer,String> tempPrefixes = new HashMap<Integer,String>();
        tempPrefixes.put(0,"");
        tempPrefixes.put(3,"k");
        tempPrefixes.put(6,"M");
        tempPrefixes.put(9,"G");
        tempPrefixes.put(12,"T");
        tempPrefixes.put(-3,"m");
        tempPrefixes.put(-6,"u");
        prefixes = Collections.unmodifiableMap(tempPrefixes);
    }

    String type;
    double value;

    public Measurement(double value, String type) {
        this.value = value;
        this.type = type;
    }

    public String toString() {
        double tval = value;
        int order = 0;
        while(tval > 1000.0) {
            tval /= 1000.0;
            order += 3;
        }
        while(tval < 1.0) {
            tval *= 1000.0;
            order -= 3;
        }
        return tval + prefixes.get(order) + type;
    }

    public static void main(String[] args) {
        Measurement dist = new Measurement(1337,"m"); // should be 1.337Km
        Measurement freq = new Measurement(12345678,"hz"); // should be 12.3Mhz
        Measurement tiny = new Measurement(0.00034,"m"); // should be 0.34mm

        System.out.println(dist);
        System.out.println(freq);
        System.out.println(tiny);

    }

}