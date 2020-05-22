public <T extends Node> void relax(T parent, Edge edge, PriorityQueue<T> priorityQueue) {
    if (this.distance > parent.distance + edge.weight){
        this.distance = parent.distance + edge.weight;
        this.parent = parent;
        priorityQueue.remove(this);
        priorityQueue.add((T) this);
    }
}