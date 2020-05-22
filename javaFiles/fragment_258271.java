public class Boss extends Angestellter {
    Boss(String v, String n, int a) { 
        super (v,n,a);
        vorname = großKleinSchreibung(v); 
        nachname = großKleinSchreibung(n);
        alter = a;
    }
}