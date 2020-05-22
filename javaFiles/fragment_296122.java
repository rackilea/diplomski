public class Colour{

    public Color colVal;

    HashMap<Integer, Color> map = new HashMap<Integer, Color>();

    public Colour() {
        map.put(0, Color.RED);
        map.put(1, Color.BLUE);
        map.put(2, Color.YELLOW);
        map.put(3, Color.GREEN);
    }

    // **** change name ****
    public Color getCol(Integer data) {
       //Color colours;
        colVal = map.get(data);
        System.out.println("colour" + colVal);
        return colVal;
    }

    // **** not sure you need this method
    public Color getColVal() {
        return colVal;
    }