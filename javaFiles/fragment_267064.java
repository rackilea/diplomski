import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import java.util.Scanner;
public class Solution {

public static void main(String args[])
{
  int a[] = new int[1000];
  Scanner s=new Scanner(System.in);
  int sum=0,count=0;
  int n=s.nextInt();
  for(int i=0;i<n;i++)
  {
    a[i]=s.nextInt();
  }
  int m=s.nextInt();
  int d=s.nextInt();
  for(int i=0;i<n;i++){ 
    for(int j=i;j<d+i;j++)
    {
      sum=sum+a[j];
      //THIS CHECK SHOULD BE OUTSIDE THE CURRENT FOR LOOP
      if(sum==m)
      {
        count++;

      }
    }sum=0; 
  }
  System.out.println(count);
}}