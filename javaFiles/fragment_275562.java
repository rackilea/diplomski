/**
*
*/

package com.JavaReference;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    public static void main(String args[]){
        int count=0;
        Integer n[];

        int i=0;
        try{
            n=OpenFile();
            int num[] = new int[n.length];

            for (i=0;i<n.length;i++){
                num[i]=n[i].intValue();
                // System.out.println( "Num"+num[i]);
            }
            count=countInversions(num);

        }
        catch(IOException e){
            e.printStackTrace();
        }

        System.out.println(" The number of inversions"+count);

    }

    public static Integer[] OpenFile()throws IOException{

        FileReader fr=new FileReader("C:/IntegerArray.txt");// to put in file name.

        BufferedReader textR= new BufferedReader(fr);
        int nLines=readLines();
        System.out.println("Number of lines"+nLines);

        Integer[] nData=new Integer[nLines];
        for (int i=0; i < nLines; i++) {
            nData[ i ] = Integer.parseInt((textR.readLine()));

        }
        textR.close();

        return nData;

    }

    public static int readLines() throws IOException{

        FileReader fr=new FileReader("C:/IntegerArray.txt");
        BufferedReader br=new BufferedReader(fr);

        int numLines=0;
        //String aLine;

        while(br.readLine()!=null){
            numLines++;
        }
        System.out.println("Number of lines readLines"+numLines);
        return numLines;

    }

    public static int countInversions(int num[]){

        int countLeft,countRight,countMerge;
        int mid=num.length/2,k;

        if (num.length<=1){

            return 0;// Number of inversions will be zero for an array of this size.
        }

        int left[]=new int[mid];
        int right[]=new int [num.length-mid];

        for (k=0;k<mid;k++){
            left[k]=num[k];
        }

        // BUG 1: you can't assume right.length == m
        for (k=0;k<right.length;k++){
            right[k]=num[mid+k];
        }

        countLeft=countInversions(left);
        countRight=countInversions(right);

        int[] result=new int[num.length];
        countMerge=mergeAndCount(left,right,result);
        /*
        * Assign it back to original array.
        */
        for (k=0;k<num.length;k++){
            num[k]=result[k];
        }

        return(countLeft+countRight+countMerge);
    }
    private static int mergeAndCount(int left[],int right[],int result[]){
        int count=0;
        int a=0,b=0,i,k=0;
        while((a<left.length)&&(b<right.length)){

            if(left[a]<right[b]){
                result[k]=left[a++];// No inversions in this case.

            }
            else{// There are inversions.

                result[k]=right[b++];
                count+=left.length-a;
            }
            k++;
        }

        // BUG 2: Merging of leftovers should be done like this
        while (a < left.length)
        {
            result[k++] = left[a++];
        }
        while (b < right.length)
        {
            result[k++] = right[b++];
        }

        return count;
    }
}