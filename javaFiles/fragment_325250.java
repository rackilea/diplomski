class SimpleComparator implements Comparator<String[]> {
    @Override
    public int compare(String[] o1, String o2[]) {       
        if(!o1[0].equalsIgnoreCase(o2[0])){
            return o1[0].compareToIgnoreCase(o2[0]);
        }
        int value1 = Integer.parseInt(o1[2]);
        int value2 = Integer.parseInt(o2[2]);
        if(value1!=value2){
            return new Integer(value1).compareTo(value2);
        }
        return 0;
    }
}