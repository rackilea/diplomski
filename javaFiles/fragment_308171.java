Please Use below logic and get result according to your requirement..
package com.test;
public class Namessplite {
    public static void main(String args[]){
    String[] names={"ABC","CAD","JKL","MNO"}; // these are names for example
    String[] atog_group = new String[10];
    String[] gtopgroup=  new String[10];
    int j=0,k=0;
    for(int i=0;i<names.length;i++){
        if((int)names[i].charAt(0)<72 && (int)names[i].charAt(0)>64){
            atog_group[j]=names[i];
            j++;
        }else{
            gtopgroup[k]=names[i];
            k++;
        }
    }
    System.out.println("A TO G Names Are :: ");
        for(int m=0;m<j;m++){
            System.out.println(atog_group[m]);  
        }
                System.out.println("G TO P Names Are :: ");
        for(int m=0;m<k;m++){
            System.out.println(gtopgroup[m]);   
        }
    }
}