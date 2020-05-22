public class Filling
{
    private String name;
    private int caloriesPerServing;

    public Filling(String name, int caloriesPerSlice)
    {
        this.name = name;
        this.caloriesPerServing = caloriesPerSlice;
    }

    public String getName() { return name;}

    public int getCaloriesPerServing() { return caloriesPerServing; }

    public String toString()
    {
        return name + " (" + caloriesPerServing + "cal)";
    }
}