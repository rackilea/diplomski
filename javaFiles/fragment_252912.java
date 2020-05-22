public class Bread
{
    private String type;
    private int caloriesPerSlice;

    public Bread(String type, int caloriesPerSlice)
    {
        this.type = type;
        this.caloriesPerSlice = caloriesPerSlice;
    }

    public String getType() { return type;}

    public int getCaloriesPerSlice() { return caloriesPerSlice; }

    public String toString()
    {
        return type + " (" + caloriesPerSlice + "cal)";
    }
}