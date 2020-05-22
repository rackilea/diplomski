package com.example;

public class ObjectTransform{

    public String name;

    public double[][] transform;

    public ObjectTransform(){
        name = "";
        transform = new double[4][4];
        for(int i=0;i<4;i++)
            for(int j=0;j<4;j++)
                transform[i][j] = i == j ? 1 : 0;
    }
}