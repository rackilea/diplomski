public abstract class Animal{

    private int animalYearAge;

    public Animal(int animalYearAge){
        this.animalYearAge = animalYearAge;
    }

    public void setAnimalYearAge(int age){
        this.animalYearAge = age;
    }

    public int getAnimalYearAge(){
        return animalYearAge;
    }

    public abstract int getHumanYearAge();        

}