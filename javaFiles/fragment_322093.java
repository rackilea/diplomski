package example;
        if (low != mid && mid != high) {
        for (int i = 0; i <= mid; i++) {
            if ( ! Determinate.isPointLeftSide(a, auxiliaryListTwo.get(i), auxiliaryListTwo.get(i + 1))) {
                p = auxiliaryListTwo.get(i);

            } else {
                if ( Determinate.isPointRightSide(a, auxiliaryListTwo.get(i + 1), auxiliaryListTwo.get(i)) && Determinate.isPointRightSide(a, auxiliaryListTwo.get(i + 1), b) ) {
                    p = auxiliaryList.get(i + 1);
                }
                else{
                    i++;
                }
            }
        }
    }