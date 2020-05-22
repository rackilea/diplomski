public class BuildingGUI extends Application implements Serializable{

    private Building theBuilding = new Building(); <-- we initialize it

    public Building getBuilding(){
        return this.theBuilding;
    }
}

public static void main(String[] args) {

    //initialize BuildingGUI object and get the Building object
    BuildingGUI building2 = new BuildingGUI();

    //we serialize the Building, by casting it to (Object) and feeding it to the method
    try{
        someClass.writeObjectToDisk((Object)building2);
    }
    catch(IOException ioe){
        ioe.printStackTrace();
    }

    BuildingGUI buildingGUI = null;
    //now for deserializing JUST THE BUILDINGGUI
    try{
        //We cast to appropriate type, because method returns 'Object'
        buildingGUI = (BuildingGUI)ObjectLoader("buildingGUI.ser");
    }
    catch(IOException ioe){
        ioe.printStackTrace();
    }
    catch(ClassNotFoundException cnfe){
        cnfe.printStackTrace();
    }

    //You can get the building this way
    Building myBuilding = buildingGUI.getBuilding();
}