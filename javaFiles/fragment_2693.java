public class Autore {

private String nome;
private String cognome;
private String periodo;
private Calendar data;

public Autore(String nome, String cognome, String periodo, Calendar data) {
    // TODO Auto-generated constructor stub
    this.nome = nome;
    this.cognome = cognome;
    this.periodo = periodo;
    this.data = data;
}

public Autore() {
    // TODO Auto-generated constructor stub
}


public String getNome() {
    return nome;
}

public void setNome(String nome) {
    this.nome = nome;
}

public String getCognome() {
    return cognome;
}

public void setCognome(String cognome) {
    this.cognome = cognome;
}

public String getPeriodo() {
    return periodo;
}

public void setPeriodo(String periodo) {
    this.periodo = periodo;
}

public Calendar getData() {
    return data;
}

public void setData(Calendar data) {
    this.data = data;
}



}