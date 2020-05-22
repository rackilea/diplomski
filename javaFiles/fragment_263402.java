public class Dog extends Animal{

    public int getHumanYearAge(){
        return this.getAnimalYearAge() * 7;
    }
}