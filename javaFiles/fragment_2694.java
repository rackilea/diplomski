public class Libro {

private String titolo;
private Autore a;
private int annoLibro;

public Libro(String titolo, Autore a, int annoLibro) {
    this.titolo = titolo;
    this.a = a;
    this.annoLibro = annoLibro;
}

public Libro() {
    // TODO Auto-generated constructor stub
}

public String getTitolo() {
    return titolo;
}

public void setTitolo(String titolo) {
    this.titolo = titolo;
}

public Autore getAutore() {
    return a;
}

public void setAutore(Autore a) {
    this.a = a;
}

public int getAnno() {
    return annoLibro;
}

public void setAnno(int annoLibro) {
    this.annoLibro = annoLibro;
}


}