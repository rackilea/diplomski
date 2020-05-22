Comparator<Geography> comparator = new Comparator<>() {
    public int compare(final Geography obj1, final Geography obj2) {
        state1 = getState(obj1);
        state2 = getState(obj2);

        int retCode = state1.compare(state2);
        if (retCode != 0)
            return retCode;

        county1 = getCounty(obj1);
        county2 = getCounty(obj2);

        retCode = county1.compare(county2);
        if(retCode != 0)
           return retCode;

        zip1 = getZip(obj1);
        zip2 = getZip(obj2);

        retCode = zip1.compare(zip2);
        return retCode;
   }
}