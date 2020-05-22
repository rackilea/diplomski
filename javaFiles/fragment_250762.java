import java.util.*;
import java.lang.reflect.*;
import java.io.*;


class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        BeanX bx=new BeanX();
        printFields(bx.getClass());
    }

    static void printFields(Class bx ) throws java.lang.Exception{

            if(bx!=null && !bx.getSimpleName().equals("String")){
                for (Field field : bx.getDeclaredFields()){
                     field.setAccessible(true);
                     System.out.println(bx.getSimpleName()+"."+field.getName() 
                     +"->" +field.getGenericType());

                     if(field.getGenericType() instanceof ParameterizedType)
                        printFields((Class)(((ParameterizedType)field.getGenericType())
                        .getActualTypeArguments()[0]));
                }
            }
    }
}

class BeanX {
   private int x1;
   private int x2;
   private List<BeanY> beany;

   public void setBeany(List<BeanY> beany){
    this.beany=beany;
   }

}

class BeanY {
   private int x3;
   private int x4;
   private List<String> strings;

   public void setStrings(List<String> strings){
    this.strings=strings;
   }
}