public enum runtimeStatus
{
    STATUS1("passed", "passedType2"), 
    STATUS2("failed", "failedType2"), 
    STATUS3("notrun", "notRunType2");

    private String statusTrue;

    private String statusFalse;

    private runtimeStatus(String statusTrueCode, String statusFalseCode)
    {
        this.statusTrue = statusTrueCode;
        this.statusFalse = statusFalseCode;

    }

    public String getStatus(boolean value)
    {
        return (value == true) ? statusTrue : statusFalse;
    }

}