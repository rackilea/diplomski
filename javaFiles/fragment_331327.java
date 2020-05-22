BlockingQueue<HashMap<Integer, double[]>> q; // = ...
BlockingQueue<HashMap<Integer, double[]>> copy = new LinkedBlockingDeque<>();//or other

for(HashMap<Integer, double[]> map : q){
    copy.add(new HashMap<>(map));
}