class Pet {
    public String name;
    public boolean indoor;

    public Pet(String name, boolean indoor) {
        this.name = name;
        this.indoor = indoor;
    }


    public String toString(){
        return name + ", " + indoor; 
    }
}

class Goat extends Pet {
    public int age;
    public String diet;
    public Goat(String name, boolean indoor, int age, String diet) {
         super(name, indoor);
         this.age = age;
         this.diet = diet;
    }