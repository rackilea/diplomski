public class MonsterSort2 {

/**
 * @param args
 */
public static void main(String[] args) {

    int elementCount = 23;

    List<String> list = new ArrayList<String>(elementCount);

    Map<String, Integer>  unitMap = new LinkedHashMap<String, Integer>();

    unitMap.put("A", 1);
    unitMap.put("C", 2);
    unitMap.put("D", 2);
    unitMap.put("B", 3);

    Random rand = new Random();

    ValueComparator bvc =  new ValueComparator(unitMap);

    TreeMap<String,Integer> sorted_map = new TreeMap<String,Integer>(bvc);

    Map<String, Double> pseudoMap = new HashMap<String, Double>(elementCount);


    sorted_map.putAll(unitMap);

    unitMap = new LinkedHashMap<String, Integer>(sorted_map);

    Iterator<String> it = unitMap.keySet().iterator();

    int shift = 0;

    while(it.hasNext()){
        String unitName = it.next();

        //prevPrior = unitList.get(unitName);

        for(int i=shift; i<elementCount; i++){
            //list.add(unitName);

            double d = 0.0;

            // generate double <> 0 or 1
            while(d == 0.0 || d == 1.0){
                d = rand.nextDouble();
            }

            pseudoMap.put(unitName + "_" + i, (double)(unitMap.get(unitName) + d));

            if(i == elementCount/unitMap.size() -1 + shift){
                shift = i;
                break;
            }
        }       

    }//while


    PriorityComparator prComp =  new PriorityComparator(pseudoMap);

    TreeMap<String,Double> sorted_map_total = new TreeMap<String,Double>(prComp);

    sorted_map_total.putAll(pseudoMap);

    list = new ArrayList<String>(elementCount);

    it = sorted_map_total.keySet().iterator();

    while(it.hasNext()){
        String unitName = it.next();

        list.add(unitName.split("_")[0]);


    }//while

    System.out.println(list);

}
}