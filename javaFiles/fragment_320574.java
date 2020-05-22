class WeekData {
   private String monday;
   private String tuesday;
   // and so on
}

class AllData {
  private final int minWeek;
  private final int maxWeek;
  private int currentWeek; // this is modified by clicking the arrows

  private Map<Integer, WeekData> weekMap;

  public IModel<WeekData> createDataModel() {
    return new IModel<WeekData>() {
       public WeekData getObject() {
         return weekMap.get( currentWeek );
       }
    }
  }

  public IModel<Integer> createWeekModel() {
    return new IModel<Integer>() {

       public Integer getObject() {
         return currentWeek;
       }
    }
  }

}