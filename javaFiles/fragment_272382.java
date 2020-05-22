private static List<Integer> sumValue(Map<String, List<Integer>> map1,
                                 Map<String, List<Integer>> map2) 
{
        List<Integer> priceValues1Int = new ArrayList<Integer>();
        List<Integer> priceValues2Int = new ArrayList<Integer>();
        List<Integer> sum = new ArrayList<Integer>();
        for (List<Integer> integer : map1.values()) {
            priceValues1Int = integer;
        }
        for (List<Integer> integer2 : map2.values()) {
            priceValues2Int = integer2;
        }
        for(int i=0; i<priceValues1Int .size(); i++){
            int sum1 =  priceValues1Int .get(i)+priceValues2Int .get(i);
            sum.add(sum1);
        }
    return sum;
}