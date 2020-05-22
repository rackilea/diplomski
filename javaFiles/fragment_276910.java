package com.example.stepup;
public class StepupTest {
    public static void main(String[] args) {
        // get steps from "start" to "finish"

        int startI = -1;
        int endI =999;
        float start = (float) startI;
        float end = (float) endI;
        double startD = (double) startI;
        double endD = (double) endI;
        int numberOfSteps = 100;

        double[] steps = Tween.get1DimSteps( start, end, numberOfSteps);
        double[] stepsD = Tween.get1DimSteps(startD, endD, numberOfSteps);
        int[] stepsI = Tween.get1DimSteps(startI, endI, numberOfSteps);

        for (int i=0; i < numberOfSteps; i++) {
            System.out.println(" " + i + ". " + steps[i] + ", " + stepsD[i] + ", " + stepsI[i]);
        }
    }
}