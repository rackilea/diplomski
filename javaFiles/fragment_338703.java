package com.example.package1;
import java.util.*;
import java.util.jar.*;
import java.net.*;

class myClass {
  public static void main(String[] args) {
    try {
    new myClass();
    } catch (Exception e) {
    System.out.println(e.getMessage());
    } finally {
    System.out.println("Done");
    try{Thread.sleep(40000);}catch(Exception ee){}
    }
  }

public myClass() throws Exception {
  String clz = getClass().getSimpleName() + ".class";
  String pth = getClass().getResource(clz).toString();
  String mnf = pth.substring(0, pth.lastIndexOf("!") + 1) + "/META-INF/MANIFEST.MF";
  String pkg = getClass().getPackage().getName().replaceAll("\\.","/");
  URL url = new URL(mnf);
  Manifest manifest = new Manifest(url.openStream());

  Attributes attr = manifest.getAttributes(pkg);
  String value = attr.getValue("Specification-Title") + " - " + 
  attr.getValue("Implementation-Title") + " " + 
  attr.getValue("Specification-Version") + " build # " + 
  attr.getValue("Implementation-Version");
  System.out.println(value);
  }
}