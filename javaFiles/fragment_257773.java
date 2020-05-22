package com.sujit;

import java.util.ArrayList;
import java.util.List;

public class CompareMessages{
    public static void main(String[] args) {
        //Assume the messages as per you said
        List<String> messages = new ArrayList<>();
        messages.add("Solution not working");
        messages.add("Message Failed");
        messages.add("Missed something");
        messages.add("This message will be ignored");

        //Your standard list of words
        List<String> list = new ArrayList<>();
        list.add("Not working");
        list.add("missed");
        list.add("failed");

        Integer count=0;
        String msg = null;  //this will store which message will be ignored
        for (String string : messages) {
            for(String standard : list) {
                if(string.toLowerCase().contains(standard.toLowerCase())){ //check if message if present in your standard list
                    count = 1;  //if it is present, Count becomes 1
                    if(count==1){
                        msg = null;
                        break;   // we can break the loop for current message to be checked with standard list if it is present
                    }
                }
                else{
                    count=0;   // if the message is not your standard, then count becomes 0
                    msg = string; 
                }
            }
        }
        if(count==0){
            System.out.println(msg);  //finally you can get which messages is wrong according to your standard list
        }
    }
}