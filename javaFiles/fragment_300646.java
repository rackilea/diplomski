Collections.sort(countryList,new Comparator<Country>() {
                    public int compare(Country o1, Country o2) {
                        if (o1.getName().length() > o2.getName().length()) return 1;
                        if (o1.getName().length() < o2.getName().length()) return -1;

                        return o1.getName().compareTo(o2.getName());
                    }
        });