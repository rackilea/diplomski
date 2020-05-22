class ThresholdFactory
{
  public static AbstractThreshold getThreshold(String criteria)
  {
    if ( criteria.equals("week") )
      return new WeekThreshold();
    if ( criteria.equals("month") )
      return new MonthThreshold();
    if ( criteria.equals("year") )
      return new YearThreshold();

    return null;
  }
}