public static void main(String[] args) {

    //initialize BuildingGUI object and get the Building object
    BuildingGUI building2 = new BuildingGUI();
    Building myBuilding = building2.getBuilding();

    //we serialize the Building, by casting it to (Object) and feeding it to the method
    try{
        someClass.writeObjectToDisk((Object)myBuilding);
    }
    catch(IOException ioe){
        ioe.printStackTrace();
    }

    Building myBuilding2 = null;
    BuildingGUI buildingGUI = null;
    //now for deserializing
    try{
        //We cast to appropriate type, because method returns 'Object'
        myBuilding2 = (Building)objectLoader("building.ser");
        buildingGUI = (BuildingGUI)objectLoader("buildingGUI.ser");
    }
    catch(IOException ioe){
        ioe.printStackTrace();
    }
    catch(ClassNotFoundException cnfe){
        cnfe.printStackTrace();
    }
}