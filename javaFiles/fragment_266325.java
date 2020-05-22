double x0 = xc - size/2 + size*i/N;
        double y0 = yc - size/2 + size*j/N;
        Complex z0 = new Complex(x0, y0);
        int escapeIterations = numberOfIterationsToCheck(z0, max);

        // set color varying hue based on escape iterations:
        Color color = Color.getHSBColor((float)escapeIterations / (float)max, 1.0f, 1.0f);

        viewer.set(i, N-1-j, color);