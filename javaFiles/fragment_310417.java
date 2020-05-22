Arrays.sort(eventStuff, new Comparator<Event>() {

        @Override
        public int compare(Event o1, Event o2) {

            if (o1.getGuests() < o2.getGuests())
                return -1;
            else if (o1.getGuests() == o2.getGuests())
                return 0;
            else
                return 1;

        }                                   
    });