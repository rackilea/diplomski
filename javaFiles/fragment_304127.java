public class Stats {

   private String channel;
   private Long startTime;
   private Long endTime;    
   private int totalUniques;
   private int totalViewtime;
   private int totalViews;
   private int totalCountries;

   ...

   private Map<String, Country> countries;

   public Map<String, Country> getCountries() {
       return countries;
   }

   public void setCountries(Map<String, Country> countries) {
       this.countries = countries;
   }

}