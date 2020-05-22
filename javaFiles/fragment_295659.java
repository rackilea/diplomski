public static void main(String[] args) {
    Baseball ball = new BaseBall(8,"green");
    System.out.println("Our ball has " + ball.getStitches() + " stitches and is " + ball.getColor());

    ball.setStitches(9);
    ball.setColor("white");
    System.out.println("Our ball has " + ball.getStitches() + " stitches and is " + ball.getColor());
}

public class Baseball
{
    private int numberOfStitches = 0;
    private String colorOfBall = "";

    //This is a constructor which is used to set initial values of an object when the object is created
    public Baseball(int newNumberOfStitches, String newColor)
    {
        numberOfStitches = newNumberOfStitches;
        colorOfBall = newColor;
    }

    //This is a getter that returns an int value.
    public int getStitches()
    {
        return numberOfStitches;
    }

    //This is a setter, which is of type void and doesn't return any value
    public void setStitches(int newNumberOfStitches)
    {
        numberOfStitches = newNumberOfStitches;
    }

    public String getColor()
    {
        return colorOfBall;
    }

    public void setColor(String newColor)
    {
        colorOfBall = newColor;
    }
}