int x = 0, y = 0, am = 0, ar = 0;
for (int i = 0; i < arr.length; i++) {
    ar += arr[x][y];

    x++;
    y++;
}
x = 0;
y = arr.length - 1;

for (int i = 0; i < arr.length; i++) {
    am += arr[x][y];

    x++;
    y--;
}