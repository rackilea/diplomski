class Entity implements Comparable<Entity> {
    String name;
    int num;
    Entity(String name, int num) {
        this.name = name;
        this.num = num;
    }
    @Override
    public int compareTo(Entity o) {
        if (this.num > o.num)
            return 1;
        else if (this.num < o.num)
            return -1;
        return 0;
    }
}