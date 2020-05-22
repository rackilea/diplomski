Map<Date, List<String>> Hash= new TreeMap<>(new Comparator<Date>() {
        @Override
        public int compare(Date o1, Date o2) {
            Calendar first = Calendar.getInstance();
            first.setTime(o1);
            Calendar second = Calendar.getInstance();
            second.setTime(o2);
            int month1 = first.get(Calendar.MONTH);
            int month2 = second.get(Calendar.MONTH);
            if (month1 != month2) {
                return month1 - month2;
            } else {
                int day1 = first.get(Calendar.DATE);
                int day2 = second.get(Calendar.DATE);
                return day1 - day2;
            }
        }
    });