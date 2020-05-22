public class Player{

    String name;
    int age; //I'm not sure what the integer is supposed to represent

    //constructor
    Player(String playerName, int playerAge){
        this.name = playerName;
        this.age = playerAge;
    }

    //getters
    public String getName(){
        return this.name;    
    }

    public int getAge(){
        return this.age;    
    }

}