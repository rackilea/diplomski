else {
                y = treeMinimum(z.right);
                yOriginalColor = y.color;
                x = y.right;
                if(y.p == z) {
                    x.p = y;
                }