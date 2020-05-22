package com.me;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Test
{
        public static List<String> splitMyString(String textValue, int textSize) {        
        ArrayList<String> myNewList= new ArrayList<String>((textValue.length() + textSize- 1) / textSize);

        for (int start = 0; start < textValue.length(); start += textSize) {
            myNewList.add(textValue.substring(start, Math.min(textValue.length(), start + textSize)));
        }
        System.out.println(myNewList.toString());
        return myNewList;
     }
    public static void main(String[] args) {

        Test.splitMyString("1234546512312312312312365", 5);

    }
}