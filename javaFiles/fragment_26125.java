Arrays.sort(order);
int j = 0;
while (j < yposCount) {
    int k = 0;
    while (k < yposCount) {
        if (order[j] == ypos[k]) {
            finalOrder[j] = k;
            // Now, if the next `order` is equal, continue looking for that value
            if ((j+1 < yposCount) && (order[j+1] == order[j])) {
                // more of the same ypos values to come
                j++;
            } else {
                // All these ypos values found, end inner loop
                break;
            }
        }
        k++;
    }
    j++;
}