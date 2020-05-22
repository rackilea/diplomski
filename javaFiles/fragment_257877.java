Collections.sort(listPeople, new Comparator<People>() {
    @Override
    public int compare(final People o1, final People o2) {
        int nameOrder = o1.getName().compareTo(o2.getName());
        if (nameOrder != 0) {
            return nameOrder;
        }

        // Elements names are equal, compare by their email
        int emailOrder = o1.getEmail().compareTo(o2.getEmail());
        if (emailOrder != 0) {
            return emailOrder ;
        }

        // Elements emails are equal, compare by their age
        int ageOrder = o1.getAge().compareTo(o2.getAge());
        // Return that in any case as we do not have another sorting criteria
        return ageOrder;
    }
});