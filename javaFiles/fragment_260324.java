package test;


import java.util.ArrayList;

import java.util.Arrays;


public class Test {


      public static void main(String[] args) {

          String sentence = "ASK NOT WHAT YOUR COUNTRY CAN DO FOR YOU ASK WHAT YOU CAN  DO FOR YOUR COUNTRY";

          String lowercaseSentence;

          lowercaseSentence = sentence.toLowerCase();

          String[] sentenceWords = lowercaseSentence.split(" ");

          int LenghtofSentence = sentenceWords.length;

          String[] uniqueString = new String[LenghtofSentence];

           ArrayList<String> unique = new ArrayList<String>();

          int k=0;
          for(int i=0;i<LenghtofSentence;i++)
          {
             if(!unique.contains(sentenceWords[i]))
             {
                unique.add(sentenceWords[i]);
                 k++;
             }
          }
          for(int i=0;i<unique.size();i++)
          {
              uniqueString[i] = unique.get(i);
              System.out.print(" "+uniqueString[i]);
          }
       }
    }