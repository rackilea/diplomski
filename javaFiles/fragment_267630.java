public class Status
{
    private boolean isDone;

    @JsonProperty("isDone")
    public boolean isDone()
    {
        return this.isDone;
    }

    @JsonProperty("isDone")
    public void setDone(boolean isDone)
    {
        this.isDone = isDone;
    }
}