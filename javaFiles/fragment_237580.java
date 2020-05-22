if (i - 1 >= 0) {
                if (fb[i - 1][j] != null) {
                    fb[i - 1][j].setBackground(Color.RED);
                }
            } else if (i + 1 < 15) {
                if (fb[i + 1][j] != null) {
                    fb[i + 1][j].setBackground(Color.RED);
                }
            } else if (j - 1 >= 0) {
                if (fb[i][j - 1] != null) {
                    fb[i][j - 1].setBackground(Color.RED);
                }
            } else if (j + 1 < 15) {
                if (fb[i][j + 1] != null) {
                    fb[i][j + 1].setBackground(Color.RED);
                }
            }