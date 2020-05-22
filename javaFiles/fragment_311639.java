Map<Integer, List<String> > periodTeachersMap = new HashMap<Integer, List<String>>();
for (Teacher teacher: teachers) {
   for (AllocablePeriod period: teacher.getPeriods()) {
       if (periodTeachersMap.get(period.getId()) == null) {
           periodTeachersMap.put(period.getId(), new ArrayList<String>());
       }
       periodTeachersMap.get(period.getId()).add(teacher.getName());
   }
}