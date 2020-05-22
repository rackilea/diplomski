class PriceComparator implements Comparator<Prices>{
    @Override
    public int compare(Prices o1, Prices o2) {
        return o2.getPrice1().compareTo(o1.getPrice1());
    }

    public  int getLeastPrice2(List<Prices> collections){
        int i =0;
        BigDecimal lowValue = collections.get(0).getPrice2();
        for (int j = 1; j < collections.size(); j++) {
            if (collections.get(j).getPrice2().compareTo(lowValue) < 0 ) {
                lowValue =  collections.get(j).getPrice2();
                i = j;
            }
        }
        return i;

    }
}