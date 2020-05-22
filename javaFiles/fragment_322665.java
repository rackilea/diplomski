public static int[] weight;
public static int[] value;
public static int maxW = 16;
public static int n;

public static class Node {
    int level;
    int weight;
    int profit;
    double bound;
}

public static class NodeComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Node n1 = (Node) o1;
        Node n2 = (Node) o2;
        if (n1.bound < n2.bound) {
            return 1;
        }
        if (n1.bound > n2.bound) {
            return -1;
        } else {
            return 0;
        }
    }
}

public static double bound(Node a) {
    int j = 0, k;
    int totalWeight;
    double result;
    if (a.weight >= maxW) {
        return 0;
    } else {
        result = a.profit;
        // j = a.level + 1;
        if (a.level < weight.length) {
            j = a.level + 1;
        }
        totalWeight = a.weight;
        // while (j <= n && totalWeight + weight[j] <= maxW) {
        while (j < n && totalWeight + weight[j] <= maxW) {
            totalWeight += weight[j];
            result += value[j];
            j++;
        }
        k = j;
        // if (k <= n) {
        if (k < n) {
            result += ((maxW - totalWeight) * (value[k] / weight[k]));
        }
        return result;
    }

}

public static void main(String[] args) {
    maxW = 16;
    n = 5;
    weight = new int[5];
    value = new int[5];
    weight[0] = 2;
    value[0] = 40;
    weight[1] = 5;
    value[1] = 30;
    weight[2] = 10;
    value[2] = 50;
    weight[3] = 15;
    value[3] = 60;
    weight[4] = 5;
    value[4] = 5;

    System.out.println(knapsack(n, maxW));
}

public static int knapsack(int n, int maxWeight) {
    NodeComparator nc = new NodeComparator();
    PriorityQueue pq = new PriorityQueue(n, nc);
    Node u, v;
    int maxprofit = 0;
    v = new Node();
    u = new Node();
    v.level = -1;
    v.profit = 0;
    v.weight = 0;
    v.bound = bound(v);
    pq.add(v);
    while (!(pq.isEmpty())) {
        // pq.remove(v);
        // Remove head of the queue
        v = (Node) pq.poll();
        u = new Node();
        if (v.bound > maxprofit) {
            u.level = v.level + 1;
            u.weight = v.weight + weight[u.level];
            u.profit = v.profit + value[u.level];

            if (u.weight <= maxW && u.profit > maxprofit) {
                maxprofit = u.profit;
            }
            u.bound = bound(u);
            if (u.bound > maxprofit) {
                pq.add(u);
            }
            // >> IZMO
            u = new Node();
            u.level = v.level + 1;
            // << IZMO
            u.weight = v.weight;
            u.profit = v.profit;
            u.bound = bound(u);
            if (u.bound > maxprofit) {
                pq.add(u);
            }
        }
    }
    return maxprofit;
}