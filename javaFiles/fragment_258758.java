for (x = 0; x < array2.length; x++) {
                for (int j = 0; j < array2[x].length; j++) {
                    if (countIndexVertical == x || j == countIndexHorizontal) {
                        array2[x][j] = 0;

                        // In your example:
                        // 1  2  3  4
                        // 1  2 20  4
                        // 1 20  2  4
                        // 1  2  3  4
                        // and if countIndexVertical=2 and countIndexHorizontal=1 
                        // (the 20 of the second row between 2 and 4), you'll have
                        // 1  0  3  4
                        // 1  0 20  4
                        // 0  0  0  0
                        // 1  0  3  4
                        // instead of
                        // 1  2  0  4
                        // 0  0  0  0
                        // 1 20  0  4
                        // 1  2  0  4
                    }
                }
            }