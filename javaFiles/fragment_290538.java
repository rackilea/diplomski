package com.azry.test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MultiDimArray {

    public Object copyArray(Object srcArray1, Object srcArray2) {

        ArrayList<Integer> dimensions = new ArrayList<Integer>();
        getDimensions(srcArray1, dimensions);
        int[] dims = new int[dimensions.size()];
        for (int i = 0; i < dims.length; i++) {
            dims[i] = dimensions.get(i);
        }

        Object dstArray = Array.newInstance(int.class, dims);
        copyArray(srcArray1, srcArray2, dstArray);
        return dstArray;
    }

    public void copyArray(Object srcArray1, Object srcArray2, Object dstArray) {
        if (srcArray1 != null && srcArray1.getClass().isArray()) {
            if (srcArray1 instanceof int[]) {
                int[] s1 = (int[])srcArray1;
                int[] s2 = (int[])srcArray2;
                int[] d = (int[])dstArray;
                for (int i = 0; i < s1.length; i++) {
                    d[i] = s1[i] + s2[i];
                }
            }
            for (int i = 0; i < Array.getLength(srcArray1); i++) {
                copyArray(Array.get(srcArray1, i), Array.get(srcArray2, i), Array.get(dstArray, i));
            }
        }
    }

    public void getDimensions(Object array, List<Integer> dimensions) {
        if (array != null && array.getClass().isArray()) {
            dimensions.add(Array.getLength(array));
            if (Array.getLength(array) > 0) {
                getDimensions(Array.get(array, 0), dimensions);
            }
        }
    }

    public static void main(String[] args) {

        int[][][] srcArray1 = new int[2][3][4];
        for (int i = 0; i < srcArray1.length; i++) {
            for (int j = 0; j < srcArray1[i].length; j++) {
                for (int k = 0; k < srcArray1[i][j].length; k++) {
                    srcArray1[i][j][k] = 2;
                }
            }
        }

        int[][][] srcArray2 = new int[2][3][4];
        for (int i = 0; i < srcArray2.length; i++) {
            for (int j = 0; j < srcArray2[i].length; j++) {
                for (int k = 0; k < srcArray2[i][j].length; k++) {
                    srcArray2[i][j][k] = 3;
                }
            }
        }

        int[][][] dstArray = (int[][][])new MultiDimArray().copyArray(srcArray1, srcArray2);

        for (int i = 0; i < dstArray.length; i++) {
            for (int j = 0; j < dstArray[i].length; j++) {
                for (int k = 0; k < dstArray[i][j].length; k++) {
                    System.out.println("[" + i + "," + j + "," + k + "] = " + dstArray[i][j][k]);
                }
            }
        }
    }
}