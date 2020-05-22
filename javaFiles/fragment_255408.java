package com.abaghel.examples;

import java.util.ArrayList;
import java.util.Collections;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.SparkSession;
import com.abaghel.examples.OuterClass.InnerClass;

public class OuterInnerDF {
  public static void main(String[] args) {
    SparkSession spark = SparkSession
            .builder()
            .appName("OuterInnerDF")
            .config("spark.sql.warehouse.dir", "/file:C:/temp")
            .master("local[2]")
            .getOrCreate();

     System.out.println("====> Create DataFrame");
     //Outer
     OuterClass us = new OuterClass();
     us.setId(111);     
     //Inner
     OuterClass.InnerClass ic = new OuterClass.InnerClass();
     ic.setStreetno("My Street");
     //list
     ArrayList<InnerClass> ar = new ArrayList<InnerClass>();
     ar.add(ic);         
     us.setListofInner(ar);  
     //DF
     Encoder<OuterClass> outerClassEncoder = Encoders.bean(OuterClass.class);        
     Dataset<OuterClass> ds = spark.createDataset(Collections.singletonList(us), outerClassEncoder);
     ds.show();
    }
}