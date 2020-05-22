//Method to serialize and store specific BuildingGUI
    public void buildingSaver(BuildingGUI building) throws IOException {
        //Create file output stream
        FileOutputStream fileOutStr = new FileOutputStream("theBuilding.ser");
        //Create object output stream and write object
        ObjectOutputStream objOutStr = new ObjectOutputStream(fileOutStr);
        objOutStr.writeObject(Building2);
        //Close all streams
        objOutStr.close();
        fileOutStr.close();
        System.out.printf("Serialized data is saved in a file  - theBuilding.ser");
    }

    //Method to deserialize BuildingGUI from file
    public BuildingGUI buildingLoader(String filename) throws IOException,
                                                    ClassNotFoundException{
        FileInputStream fileInStr = new FileInputStream(filename);
        ObjectInputStream objInStr = new ObjectInputStream(fileInStr);
        BuildingGUI building = (BuildingGUI) objInStr.readObject();
        objInStr.close();
        fileInStr.close();

        return building;
    }