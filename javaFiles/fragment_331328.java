BlockingQueue<HashMap<Integer, double[]>> q; // = ...
BlockingQueue<HashMap<Integer, double[]>> copy = new LinkedBlockingDeque<>();//or other

for(HashMap<Integer, double[]> map : q){
    Map<Integer, double[]> mapCopy = new HashMap<>();
    for(Map.Entry<Integer, double[]> entry : map.entrySet()){
        double[] array = entry.getValue();
        mapCopy.put(entry.getKey(), Arrays.copyOf(array, array.length));
    }
    copy.add(mapCopy);
}