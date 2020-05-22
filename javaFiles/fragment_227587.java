public int findId() {
   if (getAreas().isEmpty())
      return 1;
   List<Area> areas = new ArrayList<>(getAreas());
   areas.sort(Comparator.comparingInt(AutoPayArea::getId));

   for (int i = 1; i <= areas.size(); i++) {
      if (i < areas.get(i - 1).getId()) {
         return i; // "i" is missing, return that
      }
   }
   // If we haven't returned yet, it means that no ID is missing,
   // so just return the next one, which is areas.size()+1 (which just happens to be "i" again but it's out of scope now).
   return areas.size()+1;
}