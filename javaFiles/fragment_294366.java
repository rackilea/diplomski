/**
 * Uses weighting and path compression to improve efficiency
 * The nodes will form trees; each connected node will point to 
 * a parent.  In this way, union is of order O(1).
 * To keep the find as close to O(1) as possible, the tree
 * must stay flat.
 * To keep it flat:
 * 1)  Use weighting: merge the SMALLER tree into the larger
 * 2)  Use path compression; during the find(root), use the
 * fact that you are traversing the tree to help flatten it.
 * @author Ian McMaster
 *
 */
public class QuickUnionFind implements UnionFind {

private final int N;        // Number of nodes in the forest
private final int id[];     // The parent of node n (a node in a tree)
private final int sz[];     // The number of nodes in a tree; allows weighted union to work (flatter tree)

/**
 * Nodes (zero based) are initialized as not connected
 * @param n Number of nodes
 */
public QuickUnionFind(int n) {
    N = n;
    id = new int[N];
    sz = new int[N];

    /*  Initialize all nodes to point to themselves.
     *  At first, all nodes are disconnected 
     */
    for (int i=0; i<N; i++) {
        id[i] = i;
        sz[i] = 1;  // Each tree has one node
    }
}

private int root(int i) {
    while (i != id[i]) {
        id[i] = id[id[i]];  // Path compression
        i = id[i];
    }
    return i;
}

@Override
public void union(int p, int q) {
    int i = root(p);
    int j = root(q);
    /*
     * Here we use weighting to keep the tree flat.
     * The smaller tree is merged to the large one
     * A flat tree has a faster find root time
     */
    if (sz[i] < sz[j]) {
        id[i] = j;
        sz[j] += sz[i];
    } else {
        id[j] = i;
        sz[i] += sz[j];
    }

}

@Override
public boolean connected(int p, int q) {
    return root(p) == root(q);
}

@Override
public int getNumberOfTrees() {
    Set<Integer> s = new HashSet<Integer>();
    for (int i=0; i<N; i++)
        s.add(id[i]);
    return s.size();
}

}