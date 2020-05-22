class Job
{
  public static Job BAKER=new Job("baker", 7);
  public static Job BUTCHER=new Job("butcher", 12);
  public static Job CANDLESTICK_MAKER=new Job("candlestick maker", 27);

  private String name;
  private int whateverCode;

  pubilc Job(String name, int whateverCode)
  {
    this.name=name;
    this.whateverCode=whateverCode;
  }
  public String getJobName()
  {
    return name;
  }
  public int getWhateverCode()
  {
    return whateverCode;
  }
}
...
uJob.put(user, Job.BAKER);