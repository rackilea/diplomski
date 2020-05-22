public class Family {
    Family leftNeighbour;
    Family rightNeighbour;

    public Family() {}

    public static makeNeighbours(Family leftNeighbour, Family rightNeighbour)
    {
        leftNeighbour.rightNeighbour = rightNeighbour;
        rightNeighbour.leftNeighbour = leftNeighbour;
    }
}