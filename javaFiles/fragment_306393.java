class Ksiazka extends Wolumin{
    String autor,tytul;
    Ksiazka(String x, String y){
        this.autor=x;this.tytul=y;
    }
    public String toString(){
        return (getMyId()+","+autor+","+tytul); // use myId instead
    }
}

class Czasopismo extends Wolumin{
    String tytul,numerWydania;
    Czasopismo(String x, String y){
        tytul=x;
        numerWydania=y;
    }
    public String toString(){
        return (getMyId()+","+tytul+","+numerWydania); // use myId instead
    }
}