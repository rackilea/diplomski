int[] array = {1, 2, 3, 7, 8, 11, 20, 30, 50, 100};
int cont = 0;

public int searchI(int x) {
    searchR(x);
    return x;
}

private void searchR(int y) {
    if (cont < array.length) {
        if (array[cont] == y) {
            System.out.println(y); //System.out.println(cont); if you want the position as output
        } else {
            cont++;
            searchR(y);

        }
    }
}