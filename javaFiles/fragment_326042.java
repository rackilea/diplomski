public class DataObject implements Serializable {

    private JLabel label;
    private int gridWidth;
    private int gridHeight;
    private int gridXPosition;
    private int gridYPosition;

    // Your Constructor..
    public DataObject(JLabel label, int gridWidth, int gridHeight,
            int gridXPosition, int gridYPosition) {
        this.label = label;
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
        this.gridXPosition = gridXPosition;
        this.gridYPosition = gridYPosition;
    }

    // your getter and setters... 

}