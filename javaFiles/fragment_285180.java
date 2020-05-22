class Baker extends Job
{
  public static Job instance=new Baker();
  public String getJobName()
  {
    return "Baker";
  }
}
...
uJobs.put(user, Baker.instance);