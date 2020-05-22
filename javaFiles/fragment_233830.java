public static class CustomComparator implements Comparator<Meals> {
    public int compare(Meals  item1, Meals  item2) {

        int weight1;
        int weight2;

        if(item1.getType.equals("fast food") || item1.getType.equals("pizza")){
            weight1 = 1;
        }else{
            weight1 = 0;
        }

        if(item2.getType.equals("fast food") || item2.getType.equals("pizza")){
            weight2 = 1;
        }else{
            weight2 = 0;
        }


        if (weight1 == weight2)
            return 0;
        else if (weight1 > weight2)
            return 1;
        else
            return -1;
    }
}