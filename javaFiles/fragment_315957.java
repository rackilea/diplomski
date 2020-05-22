package com.hello;

public class Test {

/**
 * @param args
 */
public static void main(String[] args) {
    printNumbers(5,5);
}

private static void printNumbers(int max,int iteration)
{
    String line ="";
    int NoOfSpaces = (max-iteration)*2 -1;

    if(iteration == 0)
        return;
    for(int i=1;i<=iteration;i++)
        line = line+i;
    for(int i =0;i<NoOfSpaces;i++)
        line = line+" ";
    if(max != iteration)
        line = line +iteration;
    for(int i=iteration-1;i>=1;i--)
        line = line +i;
    System.out.println(line);
    printNumbers(max,--iteration);

  }
}