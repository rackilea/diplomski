public static int getMax(HashMap<?, Integer> map) {

    int maxValue = Integer.MIN_VALUE;
    for (Object key : map.keySet()){
        int value = map.get(key);
        if (value > maxValue){
            maxValue = value;
        }
    }
    return maxValue;
}