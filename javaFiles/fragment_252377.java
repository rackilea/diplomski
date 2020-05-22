public static void main(String[] arg) {
    List<Integer> indexList = Arrays.asList(23,32,43,45,47,56,49,47); // get this from database
    List<Integer> valueList = Arrays.asList(20,20,18,24,10,6,2,12); // get this from database
    List<Pair> pairList = new ArrayList<>();
    for(int i = 0; i < indexList.size();i++){
        pairList.add(new Pair(indexList.get(i), valueList.get(i)));
    }
    int sum = 0;
    int min = -1;
    int max = -1;

    for(int i = 0; i < pairList.size(); i++){
        Pair p = pairList.get(i);
        if(sum == 0){
            min = p.key;
            max = p.key;
        }
        sum += p.value;
        if(sum < LIMIT){
            max = p.key;
        } else {
            if(sum > LIMIT){
                i--;
            } else {
                max = p.key;
            }
            System.out.println(min+"_"+max);
            sum = 0;
        }
    }
}