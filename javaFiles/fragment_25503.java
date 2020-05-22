public class NomClient implements Comparable<NomClient> {

String nom;

public String getNom() {
    return this.nom;
}

public void setNom(final String nom) {
    this.nom = nom;
}

@Override
public String toString() {
    return this.nom;
}

@Override
public int compareTo(NomClient other) {
    // compareTo should return < 0 if this is supposed to be
    // less than other, > 0 if this is supposed to be greater than
    // other and 0 if they are supposed to be equal
    int last = 10;
    if (other != null){
        last = -10;
        if (this.nom != null){
            last = this.nom.compareTo(other.nom);
            }
    }
    return last;