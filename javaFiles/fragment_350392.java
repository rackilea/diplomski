PriorityQueue<Cost> queue = new PriorityQueue<Cost>();
    queue.add(new Cost(1, "one", 1));
    queue.add(new Cost(2, "two", 2));
    int id = 2;// Id to be found
    for (Cost cost : queue) {
        if (cost.getId() == 2) {
            System.out.println(cost);
        }
    }