import java.util.Stack;

public final class CircuitFinding {
    static int k, n;
    int[][] a = new int[k][n];
    int[][] b = new int[k][n];
    boolean[] blocked = new boolean[n];
    int[] v = new int[k];
    int s = 1;
    Stack<Integer> stack = new Stack<Integer>();

    private void unblock(int u) {
        blocked[u] = false;
        for (int w : b[u]) {
            //delete w from B(u)
            if (blocked[w]) {
                unblock(w);
            }
        }
    }

    private boolean circuit(int v) {
        boolean f = false;
        stack.push(v);
        blocked[v] = true;
        L1:
        for (int w : a[v]) {
            if (w == s) {
                //output circuit composed of stack followed by s;
                f = true;
            } else if (!blocked[w]) {
                if (circuit(w)) {
                    f = true;
                }
            }
        }
        L2:
        if (f) {
            unblock(v);
        } else {
            for (int w : a[v]) {
                //if (v∉B(w)) put v on B(w);
            }
        }
        v = stack.pop();
        return f;
    }

    public void main() {
        while (s < n) {
            //A:= adjacency structure of strong component K with least
            //vertex in subgraph of G induced by {s, s+ 1, n};
            if (a[k] != null) {
                //s := least vertex in V;
                for (int i : v) {
                    blocked[i] = false;
                    b[i] = null;
                }
                L3:
                circuit(s);
                s++;
            } else {
                s = n;
            }
        }
    }
}