package com.example.stepup;
public class Tween {
    public static int[] get1DimSteps (int start, int end, int steps) {
        double[] preciseResult = get1DimSteps((double) start, (double) end, steps);
        int[] result = new int[steps];
        for (int i=0; i<steps; i++) {
            result[i] = (int) (preciseResult[i] + 0.5D);
        }
        return result;
    }

    public static double[] get1DimSteps (float start, float end, int steps) {
        double[] result = get1DimSteps((double)start, (double)end, steps);
        return result;
    }

    public static double[] get1DimSteps (double start, double end, int steps) {
        double distance;
        double stepSize;
        double[] result = new double[steps];

        distance = end - start;
        stepSize = distance / steps;
        for (int i=0; i < steps; i++) {
            result[i] = start + stepSize*i;
        }
        return result;
    }
}