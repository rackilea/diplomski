public void implode(int[] ary) {
    int swapper = -1;

    int[] newARY = new int[ary.length];
    int current = -1;

    for (int i = 0; i < ary.length; i++) {
        if (current != ary[i]) {
            newARY[i] = ary[i];
            current = ary[i];
        }

    }

    for (int i = 0; i < newARY.length - 1; i++) {
        if (newARY[i] == 0 && newARY[i + 1] != 0) {
            for (int j = i; (j + 1) < newARY.length; j++) {
                swapper = newARY[j + 1];
                newARY[j] = swapper;
                newARY[j + 1] = 0;
            }
        }
    }

    for (int i = 0; i < newARY.length; i++) {
        System.out.print(newARY[i] + " ");
    }

}