public enum Secret
{
    TONGA("George Tupou V, the King of Tonga, dies in Hong Kong at the age of 63."), 
    GERMANY("Joachim Gauck is elected President of Germany."),
    SKIING("Lindsey Vonn and Marcel Hirscher win the Alpine Skiing World Cup.");

    private final String message;

    private Secret(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return this.message;
    }
}