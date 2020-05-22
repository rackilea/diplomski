public class Product {
    public String name;
    public int coordinaat;

    public Product() {}

    public Product(String name, int coordinaat) {
        this.name = name;
        this.coordinaat = coordinaat;
    }

    public void setCoordinaat(int coordinaat) {
        this.coordinaat = coordinaat;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getCoordinaat(){
        return coordinaat;
    }

    public String toString(){
        return name;
    }
}