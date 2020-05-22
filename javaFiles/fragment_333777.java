public Graph() {

    Random r = new Random();

    int range = r.nextInt(maxT) + 3; // number of nodes
    for(int i = 0; i<range; i++){
        List<Transmission> trans = new ArrayList<Transmission>();
        tasks.put(new Task(i), trans);
    }
    System.out.println("Number of tasks: " + tasks.size());

    List<Task> keys = new ArrayList<Task>(tasks.keySet());
    for(int i = 0; i < keys.size() - 1; i++) {
        Task task1 = keys.get(i);
        List<Transmission> task1Transmissions = tasks.get(task1);
        task1Transmissions.add(new Transmission(task1, keys.get(i + 1)));
        for(int j = i + 2; j < keys.size(); j++) {
            if(r.nextInt(100) < chance)
                task1Transmissions.add(new Transmission(task1, keys.get(j)));
        }
    }
}