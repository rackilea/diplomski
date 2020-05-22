Arrays.sort(t, new Comparator<AlcoholDrink>() { 
        // here I try sorting the elements by their alcohol value
        @Override
        public int compare(AlcoholDrink o1, AlcoholDrink o2) {
           return o1.getAlcohol().compareTo(o2.getAlcohol());
        }
    });