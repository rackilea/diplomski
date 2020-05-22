/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
 class Sequence {

public static void main(String[] args) {
    int [] tab = new int[6];
    for(int i=0;i<=5;i++){
         tab[i] = (int) (Math.random()*30);
        System.out.println(tab[i]);
    }
    int a,b;
    for(int i=0;i<=4;i++){
        a=tab[i];
        b=tab[i+1];

                while(a<b && i<4){

                        a=b;
                        b=tab[i+2];
                        i++;

                }
        System.out.println("There is end of increasing sequence");

    }

}}