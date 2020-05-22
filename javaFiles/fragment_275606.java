public class Pathfinder {
private static final int M = 5;
private static final int N = 5;
private static final int fila[] = {-1, 0, 0, 1, -1, -1, 1, 1};
private static final int columna[] = {0, -1, 1, 0, -1, 1, -1, 1};
private static boolean esValido(int matriz[][], boolean visitado[][], int fil, int col, int k) {
    if(k < 4)
        return ((fil >= 0) && (fil < M) && (col >= 0) && (col < N) && matriz[fil][col] < 4 && !visitado[fil][col]);
    else if (k == 4)
        return ((fil >= 0) && (fil < M) && (col >= 0) && (col < N) && matriz[fil][col] < 4 && !visitado[fil][col] && esValido(matriz, visitado, fil, col + 1, 0) && esValido(matriz, visitado, fil + 1, col, 0));
    else if (k == 5)
        return ((fil >= 0) && (fil < M) && (col >= 0) && (col < N) && matriz[fil][col] < 4 && !visitado[fil][col] && esValido(matriz, visitado, fil, col - 1, 0) && esValido(matriz, visitado, fil + 1, col, 0));
    else if (k == 6)
        return ((fil >= 0) && (fil < M) && (col >= 0) && (col < N) && matriz[fil][col] < 4 && !visitado[fil][col] && esValido(matriz, visitado, fil, col + 1, 0) && esValido(matriz, visitado, fil - 1, col, 0));
    else
        return ((fil >= 0) && (fil < M) && (col >= 0) && (col < N) && matriz[fil][col] < 4 && !visitado[fil][col] && esValido(matriz, visitado, fil, col - 1, 0) && esValido(matriz, visitado, fil - 1, col, 0));
}
private static int absoluto (int n) {
    return n > 0 ? n : -n;
}

public static void BFS(int matriz[][], int i, int j, int x, int y) {
    boolean [][] visitado = new boolean [M][N];
    PriorityQueue<Nodo> cola = new PriorityQueue<Nodo>();
    visitado[i][j] = true;
    cola.add(new Nodo(i, j, 0, absoluto(x - i) + absoluto(y - j)));
    int mincost = Integer.MAX_VALUE;
    int cost, aux;
    while(!cola.isEmpty()) {
        Nodo nodo = cola.poll();
        i = nodo.x;
        j = nodo.y;
        cost = nodo.cost;
        if(i == x && j == y) {
            mincost = cost;
            break;
        }
        for(int k = 0; k < 8; k++) {
            aux = 0;
            if(esValido(matriz, visitado, i + fila[k], j + columna[k], k)) {
                if(k < 4)
                    aux = 1;
                else
                    aux = 2;
                visitado[i + fila[k]][j + columna[k]] = true;
                switch(matriz[i + fila[k]][j + columna[k]]) {
                case 0:
                    cola.add(new Nodo(i + fila[k], j + columna[k], cost + aux, absoluto(x - i + fila[k]) + absoluto(y - j + columna[k])));
                case 1:
                    cola.add(new Nodo(i + fila[k], j + columna[k], cost + aux*2, absoluto(x - i + fila[k]) + absoluto(y - j + columna[k])));
                case 2:
                    cola.add(new Nodo(i + fila[k], j + columna[k], cost + aux*3, absoluto(x - i + fila[k]) + absoluto(y - j + columna[k])));
                case 3:
                    cola.add(new Nodo(i + fila[k], j + columna[k], cost + aux*4, absoluto(x - i + fila[k]) + absoluto(y - j + columna[k])));
                }   
            }
        }
    }

    if(mincost != Integer.MAX_VALUE)
        System.out.print("The path of minimum cost to the destination is " + mincost + ".");
    else
        System.out.print("Destination cannot be reached.");
}
}