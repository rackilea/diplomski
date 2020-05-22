String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
double root = Math.sqrt(alphabet.length());
int width = (int) Math.round(root);
int height = width < root ? width + 1 : width;
char[][] result = IntStream.range(0, height)
                           .mapToObj(i -> new char[width])
                           .toArray(i -> new char[height][]);

int x = 0, y = 0, sum = 0;

for (char c : alphabet.toCharArray()) {
    result[x][y] = c;

    y = x == Math.min(sum, height - 1) ? Math.min(++sum, width - 1) : y - 1;
    x = sum - y;
}

System.out.println(Arrays.deepToString(result));