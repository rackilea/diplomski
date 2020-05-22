int k = 0; // initiate k with 0
for (Map.Entry<Integer, ArrayList<Integer>> e : hmm.entrySet()) {
    count = 0;

    //you can move this part to another method to avoid deep nested code
    for (Integer mapValue : e.getValue()) {
        if (mapValue.equals(listOperateur.get(k++))) {
            count = count + 1;        
        }
    }

    sim.put(e.getKey(), count);
    k=0;
}