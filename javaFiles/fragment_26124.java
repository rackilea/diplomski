Arrays.sort(order);
int j = 0;
while (j < yposCount) {
    int k = 0;
    while (k < yposCount) {
        if (order[j] == ypos[k]) {
            finalOrder[j] = k;
        }
        k++;
    }
    j++;
}