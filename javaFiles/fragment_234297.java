//Initialization
ArrayList<Float> origOrder = new ArrayList<Float>();
origOrder.add(new Float(.43423));
origOrder.add(new Float(.43423));
origOrder.add(new Float(.2132));
origOrder.add(new Float(.3242));

//Copy original ArrayList
ArrayList<Float> sortedOrder = new ArrayList<Float>(origOrder);

//Remove duplicates
HashSet hs = new HashSet();
hs.addAll(sortedOrder);
sortedOrder.clear();
sortedOrder.addAll(hs);

//Sort copy in descending order
Collections.sort(sortedOrder, Collections.reverseOrder());

//ArrayList for result
ArrayList<Integer> result = new ArrayList<Integer>();

//For each float in the original ArrayList
for (Float f : origOrder) {

    //Add their index in the sorted order to the result list, plus 1 to start with 1
    result.add(sortedOrder.indexOf(f) + 1);
}

System.out.println(result);