package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test
{

  public static boolean P (String a, String b)
  {
    return a.length() == b.length() && !a.equals(b);
  }

  public static void main (String[] args)
  {
    List<String> list = new ArrayList<String>();
    list.add ("aaa");
    list.add ("bbb");
    list.add ("ccc");
    list.add ("cccc");
    list.add ("dddd");
    list.add ("ddd");

    Map<String, List<String>> map = 
      list.stream()
          .collect(Collectors.toMap(a -> a, a -> list.stream()
                                                     .filter(b -> P(a,b))
                                                     .collect(Collectors.toList()))
               );
    for (String key : map.keySet ()) {
      System.out.print (key + ": " );
      for (String value : map.get(key)) {
        System.out.print (value+ " ");
      }
      System.out.println("");
    }
  }

}