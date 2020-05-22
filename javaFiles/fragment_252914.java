public class Sandwich
{
    private Bread bread;
    private Filling filling;

    public Sandwich(Bread bread, Filling filling)
    {
        this.bread = bread;
        this.filling = filling;
    }

    public int getTotalCalories()
    {
        return 2 * bread.getCaloriesPerSlice() + filling.getCaloriesPerServing();
    }

    public String toString()
    {
        return "Bread: " + bread.toString() + "\nFilling: " + filling.toString();
    }
}