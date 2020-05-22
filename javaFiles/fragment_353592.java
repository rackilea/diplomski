for (int l = 0; l < n; l++) {
 foo:    for (int i = 1; i < (n - 2); i++) {
            for (int j = i + 1; j < (n - 1); j++) {
                for (int k = j + 1; k < n; k++) {
                    if (l != i && l != j && l != k) {
                        boolean b = isOK(pointList.get(l), pointList.get(i), pointList.get(j), pointList.get(k));
                        System.out.println(b);
                        if (b == true) {
                            pointList.remove(pointList.get(l);
                            n--;
                            break foo;
                        }
                        else
                            System.out.println(b);
                    }

                }

            }
        }
    }