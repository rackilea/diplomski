public class Nodo implements Comparable<Nodo> {
public int x, y, cost, dist, total;
public Nodo(int x, int y, int cost, int dist){
    this.x = x;
    this.y = y;
    this.cost = cost;
    this.dist = dist;
    this.total = this.cost + this.dist;
}
public int compareTo(Nodo n) {
    if(this.total < n.total)
        return -1;
    else if(this.total > n.total)
        return 1;
    else
        return 0;
}
}