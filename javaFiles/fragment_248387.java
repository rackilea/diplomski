Map<String, Multimap<String, Subject>> timetable = new HashMap<>();
 for ...
   Multimap<String, Subject> multimap = timetable.get(subject.den);
   if (multimap == null) {
     multimap = HashMultimap.create();
     timetable.put(subject.den, multimap);
   }
   multimap.put(subject.hod, subject);