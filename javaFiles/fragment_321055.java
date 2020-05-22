int[] filter = new int[13];
for (int i = 0; i < 5; i++) {
    filter[cards[i]]++;
}

int j = 0;
while (j < 13) {
    if (filter[j] > 0) {
        int length = 0;
        while (filter[j] > 0) {
            length++;
            j++;
        }
        if (length == 3) {
            for (int k = 0; k < filter[j - 1] * filter[j - 2] * filter[j - 3]; k++) {
                System.out.print(3 + " ");
            }
        }
        if (length == 4) {
            for (int k = 0; k < filter[j-1] * filter[j - 2] * filter[j - 3] * filter[j - 4]; k++) {
                System.out.print(4 + " ");
            }
            for (int k = 0; k < filter[j-1] * filter[j - 2] * filter[j - 3]; k++) {
                System.out.print(3 + " ");
            }
            for (int k = 0; k < filter[j - 2] * filter[j - 3] * filter[j - 4]; k++) {
                System.out.print(3 + " ");
            }
        }
        if (length == 5) {
            System.out.println("5 4 4 3 3 3");
        }
    }
    j++;
}