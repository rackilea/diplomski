public class Graph {

    private final int maxT = 3;
    private final int chance = 30;  //chance to connect edges
    Map<Task, Map<Task, Transmission>> tasks = new HashMap<>();

    public Graph() {

        Random r = new Random();

        int range = r.nextInt(maxT) + 3; // number of nodes
        for(int i = 0; i<range; i++){
            Map<Task, Transmission> trans = new HashMap<>();
            tasks.put(new Task(i), trans);
        }
        System.out.println("Number of tasks: " + tasks.size());

        for(Task key1 : tasks.keySet()){
            for(Task key2 : tasks.keySet()){
                if(key1 != key2
                        && !tasks.get(key2).containsKey(key1) // Don't generate an edge, if there already is a reverse edge
                        && (tasks.get(key1).isEmpty() // Always generate an edge, if there is none
                            || r.nextInt(100) < chance))
                {
                    tasks.get(key1).put(key2, new Transmission(key1,key2));
                }
            }
        }

    }

    public void printGraph(){
        System.out.println("Generated graph:\n");
        for(Task key : tasks.keySet()){
            System.out.println(key.getId());
            for(Transmission ts : tasks.get(key).values()){
                System.out.println("\t" + ts.getT1().getId() + " -> " + ts.getT2().getId());
            }
        }       
    }
}