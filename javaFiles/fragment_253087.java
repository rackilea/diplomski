private static class Task extends ArrayList<Integer> implements Runnable{
    private final ConcurrentHashMap<Integer, String> map;

    public Task(ConcurrentHashMap<Integer, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        try{
            for (Integer i : this) {
                // Simulate some crunching: write to the stdout in 10 iterations for each number: 10 000 prints for each Runnable
                for (int j = 0; j < 10; j++) {
                    System.out.println("Iteration "+j+" for "+i);
                }
                // Store something in the map, namely that this Integer, or T in your case, has been processed
                map.put(i, "Done");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}