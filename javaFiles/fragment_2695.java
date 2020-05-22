class Editore {
private String nome;
private ArrayList<Libro> libri;
protected int k=0;//scorri

public Editore(){} 

public Editore(String nome, ArrayList<Libro> libri){
    this.nome=nome;
    this.libri=libri;
}

public String getNome(){
    return this.nome;
}

public ArrayList<Libro> getLibri(){
    return this.libri;
}

public void setNome(String n){
    this.nome=n;
}

public void setLibri(ArrayList<Libro> l){
    this.libri=l;
}

public ArrayList<Libro> getLibriByAutore(ArrayList<Libro> e,String n, String c){
    ArrayList<Libro> list = new ArrayList<Libro>();
    for(Libro p : e){
        if(p.getAutore().getNome().equals(n) && p.getAutore().getCognome().equals(c)){
            list.add(p);
        }
    }
    return list;
}

}