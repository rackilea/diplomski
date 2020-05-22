public static boolean canPass(int[][]a, int i, int j, int oldValue){
    if((j >= a[0].length) || (j < 0) || (i >= a.length) || (i < 0)){
        return false;
    }
    return a[i][j] > oldValue;
}

// added a helper function to reduce repetitive code
public static int chooseShortest(int nextPath, int currentPath){
    if (nextPath != -1){
        if (currentPath == -1 || currentPath > nextPath){
                return nextPath;
            }
        }
    }
    return currentPath;
}

public static int path(int[][]a, int i, int j)
{
    // This is the end condition
    // there is one step left so return 1
    if((i == a.length - 1) && (j==a[0].length - 1)){
        return 1;
    }

    int shortestPath = -1;

    if (canPass(a, i, j + 1, a[i][j])){
        shortestPath = chooseShortest(path(a, i, j + 1), shortestPath);
    }
    if (canPass(a, i, j - 1, a[i][j])){
        shortestPath = chooseShortest(path(a, i, j - 1), shortestPath);
    }
    if (canPass(a, i + 1, j, a[i][j])){
        shortestPath = chooseShortest(path(a, i + 1, j), shortestPath);
    }
    if (canPass(a, i - 1, j, a[i][j])){
        shortestPath = chooseShortest(path(a, i - 1, j), shortestPath);
    }
    // if all 4 paths return -1 there is no path possible from here
    if (shortestPath == -1){
        return -1;
    }

    // return the shortest path + 1 step to get there
    return shortestPath + 1;
}