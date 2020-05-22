for (int iX = 0; iX < width; iX++) {
        for (int iY = 0; iY < height; iY++) {
            Arrays.fill(x, bitmap.getPixel(iX, iY));
            // Result color components.
            int[] res = new int[3];
            short total = 0;
            for (int i = 0; i < 3; i++) {
                res[i] = p1[i] * Math.pow(x[i], 5) + p2[i]
                        * Math.pow(x[i], 4) + p3[i] * Math.pow(x[i], 3)
                        + p4[i] * Math.pow(x[i], 2) + p5[i] * x[i] + p6[i];
                // Make sure final value is in range [0, 255]
                res[i] = Math.min(255, Math.max(0, res[i]));
            }
            output.setPixel(iX, iY, Color.rgb(res[0], res[1], res[2]);
        }
    }