@Override
        public int compare(AlcoholDrink o1, AlcoholDrink o2) {
            int at1 = (int)o1.getAlcohol(); // get the alcohol value
            int at2 = (int)o2.getAlcohol(); // get the alcohol value
            if(at1>at2)
                return -1;
            else if(at1<at2 )
                return 1;
            return 0;
        }