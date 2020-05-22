public class State{
    private int id;
    private String name;

    public State(int id, String name){
       this.id=id;
       this.name=name;
    }

    public int getId(){
       return id;
    }

    public void setId(int id){
       this.id= id;
    }
    public String getName(){
       return name;
    }

    public void setName(String name){
       this.name=name;
    }

}


public class City{
    private int id;
    private String name;
    private int stateId;

    public State(int id, String name, int stateId){
       this.id=id;
       this.name=name;
       this.stateId=stateId;
    }

    public int getId(){
       return id;
    }

    public void setId(int id){
       this.id= id;
    }
    public String getName(){
       return name;
    }

    public void setName(String name){
       this.name=name;
    }

    public int getStateId(){
       return stateId;
    }

    public void setStateId(int id){
       this.stateId= id;
    }

}