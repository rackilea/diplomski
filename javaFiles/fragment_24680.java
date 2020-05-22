public class DrunkResult
{
    boolean jail = false;

    int stepCount = 0;

    public DrunkResult(boolean jail, int stepCount)
    {
        this.jail = jail;
        this.stepCount = stepCount;
    }

    public boolean isInJail()
    {
        return jail;
    }

    public int getSteps()
    {
        return stepCount;

    }

}