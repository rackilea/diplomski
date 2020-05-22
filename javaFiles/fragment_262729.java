static void sort(List<PeopleByDays> peeps) {
        Collections.sort(peeps, new Comparator<PeopleByDays>() {
            @Override
            public int compare(PeopleByDays p1, PeopleByDays p2) {
                List<Date> days1 = p1.getDays();
                List<Date> days2 = p2.getDays();
                Collections.sort(days1);
                Collections.sort(days2);
                for (int i = 0; i < days1.size() && i < days2.size(); i++) {
                    int compare = days1.get(i).compareTo(days2.get(i));
                    if (compare != 0) {
                        return compare;
                    }
                }
                return days1.size() - days2.size();
            }
        });
    }