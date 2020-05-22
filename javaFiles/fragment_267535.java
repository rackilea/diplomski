List<Schedule> schedules = someAPI();
Map<String, String> map = 
schedules.stream()
         .collect(toMap(Schedule::getTag, Schedule::getTimeStart, 
                        (t1,t2)-> t1.compareTo(t2) < 0 ? t1 : t2))
                );