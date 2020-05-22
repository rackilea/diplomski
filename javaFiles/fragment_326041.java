public static void main(String[] args) {

    // Creating a JLabel
    JLabel label = new JLabel("REHAN JAVED");
    label.setForeground(Color.RED);
    label.setSize(new Dimension(500, 500));

    // adding it into the file.
    addItIntoFile(new DataObject(label, 200, 50, 0, 1));

    // reading file..
    DataObject dataObj = readDataObject();
    JLabel newLabel = dataObj.getLabel();
    int x = dataObj.getXPosition();
    // and take all the data from getters.

    System.out.println(newLabel.getText()+"\n"+newLabel.getForeground()+"\n"+label.getSize());

}


public static void addItIntoFile(DataObject dataObj) {

    File file = new File("data.txt");

    try {

        file.createNewFile();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(dataObj);
        oos.close();

        // You can handle the different exceptions according to you. 
    } catch (Exception e) {
        e.printStackTrace();
    }

}

public static DataObject readDataObject() {

    DataObject dataObj = null;

    try {

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("data.txt")));
        dataObj = (DataObject) ois.readObject();
        ois.close();

        // You can handle the different exceptions according to you. 
    } catch (Exception e) {
        e.printStackTrace();
    }

    // Handling null data..
    if(dataObj == null) {
        dataObj = new DataObject(new JLabel(), 0, 0, 0, 0);
    }

    return dataObj;

}