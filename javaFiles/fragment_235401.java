ArrayList<Integer> list = new ArrayList<>();
Scanner s = new Scanner(System.in);
while (s.hasNextInt()) {
    list.add(s.nextInt());
}
int n = list.size();
double sqrt = Math.sqrt(n);
int x = (int) sqrt;
if(Math.pow(sqrt,2) != Math.pow(x,2)) {
    //wrong input - it wasn't a square
}
int[][] array = new int[x][x];
int index = 0;
for (int i = 0; i < x; i++) {
    for (int j = 0; j < x; j++) {
        array[i][j] = array.get(index++);
    }
}