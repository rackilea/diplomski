public class MaxMinArray<T extends Comparable<T>> {

    private T getMin(T[] arr){
         T min = arr[0];
         for (int i = 0; i<arr.length; i++){
             min = (arr[i].compareTo(min) < 0) ? arr[i] : min;
         }
         return min;
    }
    // ...