// assume (x,y) is position in array you want to get neighbours from
// assume 'array' is your array with x first and then y
// assume T is type of your array stuff

ArrayList<T> list = new ArrayList<T>();

for (int i = x - 1; i <= x + 1; i++) {
    for (int j = y - 1; j <= y + 1; j++) {
        // check if (i,j) is in array bounds
        if (i >= 0 && j >= 0 && i < array.length() && j < array[i].length()) {
            // the point isn't its own neighbour
            if (i != x && j != y)
                list.add(array[i][j]);
        }
    }
}
return list.toArray();