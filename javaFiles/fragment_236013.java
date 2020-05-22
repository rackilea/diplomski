// processing numbers as strings
List<String> array = Arrays.asList("854", "854853", "854855");
Collections.sort(array, new Comparator<String>() {
   @Override
   public int compare(String o1, String o2)
   {
      // negative since we want biggest first
      return -(o1+o2).compareTo(o2+o1);
   }
});