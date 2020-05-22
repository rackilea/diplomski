package com.shashi.mpoole;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.URISyntaxException;

public class LinearEquation {

    public static void main(String[] args) throws URISyntaxException {


        LinearEquation linearEquation = new LinearEquation();
         InputStream in = LinearEquation.class.getResourceAsStream("../../../Inputs.txt");

            // Inputs Taken
            try {
                // Reading Inputs
                BufferedReader reader=new BufferedReader(new InputStreamReader(in));
                String line=null;
                // Separated by Comma m=4,x=2,c=5
                    while((line=reader.readLine())!=null){
                        LinearEqInput lei = new LinearEqInput();
                        String[] inputs = line.split(",");
                        //Getting array [m=4,x=2,c=5]
                        for (int i = 0; i < inputs.length; i++) {

                            String[] keyval = inputs[i].split("=");
                            //Getting vallue [m,4]
                            linearEquation.setValue(lei, keyval[0], keyval[1]);

                        }
                        System.out.print("[Inputs: m= " + lei.m + " x= " + lei.x + " ,c= " + lei.c + "]");
                        //result
                        System.out.println(" Output :" + linearEquation.calculate(lei));

                    }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


    }

    // This method use reflection to store the value of a field in the class LinearEqInput
    public void setValue(LinearEqInput lei,String fieldName, String value) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
    {
        Field f = lei.getClass().getDeclaredField(fieldName);
        f.setDouble(lei, Double.parseDouble(value));

    }

    //Calculating the Y
    public double calculate(LinearEqInput lei)
    {
        return lei.m*lei.x + lei.c;
    }



}



class LinearEqInput
{
//Inputs
    double m,x,c = 0;

}